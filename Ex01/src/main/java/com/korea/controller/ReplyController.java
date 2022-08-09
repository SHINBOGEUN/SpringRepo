package com.korea.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.korea.domain.Criteria;
import com.korea.domain.ReplyDTO;
import com.korea.domain.ReplyPageDTO;
import com.korea.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/replies")
@AllArgsConstructor
@RestController
public class ReplyController {
	private ReplyService service;
	
	@PostMapping(value = "/new", consumes = "application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyDTO dto) {
		log.info("ReplyDTO : " + dto);
		int insertCount = service.register(dto);
		log.info("Reply INSERT COUNT : " + insertCount);
		
		return insertCount == 1 ? new ResponseEntity<>("success",HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
//	@GetMapping(value="/pages/{bno}/{page}",
//			produces= {
//					MediaType.APPLICATION_XML_VALUE,
//					MediaType.APPLICATION_JSON_UTF8_VALUE
//			})
//	public ResponseEntity<List<ReplyDTO>> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno){
//		
//		log.info("Get list ...");
//		Criteria cri = new Criteria(page, 10);
//		log.info(cri);
//		return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);
//	}
	
	//조회
	@GetMapping(value="/{rno}",
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE
			}
		)
	public ResponseEntity<ReplyDTO> get(@PathVariable("rno")Long rno){
		log.info("Get_......" + rno);
		
		return new ResponseEntity<>(service.get(rno),HttpStatus.OK);
	}
	
	//삭제
	@DeleteMapping(value="/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		log.info("remove ...." + rno);
		return service.remove(rno) == 1
				? new ResponseEntity<>("Success", HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//수정
	@RequestMapping(method= {RequestMethod.PUT, RequestMethod.PATCH },
			value="/{rno}",
			consumes = "application/json", 		//JSON 방식의 데이터만 처리하도록
			produces = {MediaType.TEXT_PLAIN_VALUE})	// 문자열을 반환하도록
	public ResponseEntity<String> modify(
			@RequestBody ReplyDTO vo,
			@PathVariable("rno") Long rno) {
		vo.setRno(rno);
		log.info("rno: " +rno);
		log.info("modify: "+ vo);
		
		return service.modify(vo)==1
		? new ResponseEntity<> ("success", HttpStatus.OK)
		: new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	@GetMapping(value = "/pages/{bno}/{page}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyPageDTO> getList (@PathVariable("page") int page, @PathVariable("bno") Long bno){
		log.info("Get list,...");
		Criteria cri = new Criteria(page,10);
		log.info(cri);
		
		return new ResponseEntity<>(service.getListPage(cri, bno), HttpStatus.OK);
	}
	
}
