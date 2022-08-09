package com.korea.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.domain.RestSampleDTO;
import com.korea.domain.Ticket;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/restsample")
@Log4j


public class RestSampleContoller {
	
	@GetMapping(value = "/getText", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public RestSampleDTO test1() {
//		log.info("MIME TYPE : "+ MediaType.TEXT_PLAIN_VALUE);
		return new RestSampleDTO(112,"스타","로드");
	}
	
	@GetMapping(value = "/getList")
	public List<RestSampleDTO> getList(){
		
//		return IntStream.range(1, 10).mapToObj(i->new RestSampleDTO(i, i + "First", i + "Last"))
//				.collect(Collectors.toList());
		
		//for문 사용
		List<RestSampleDTO> list = new ArrayList<RestSampleDTO>();
		RestSampleDTO dto = null;
		for (int i = 0; i < 10; i++) {
			dto = new RestSampleDTO();
			dto.setFirstName(i+ "홍");
			dto.setLastName("길동" + i);
			dto.setMno(i);
			list.add(dto);
			
		}
		return list;
	}
	
	@GetMapping(value = "/getMap")
	public Map<String , RestSampleDTO> getmap(){
		Map<String , RestSampleDTO> map = new HashMap(); 
		map.put("Frist", new RestSampleDTO(111,"그루트", "주니어"));
		return map;
	}
	
	@GetMapping(value = "/check", params = {"height","weight"})
	public ResponseEntity<RestSampleDTO> check(Double height, Double weight){
		
		RestSampleDTO dto = new RestSampleDTO(0,"" + height,"" +weight);
		ResponseEntity<RestSampleDTO> result = null;
		
		if (height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(dto);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(dto);
		}
		return result;
	}
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {
		return new String[] {"category :" + cat, "productid :" + pid}; 
	}
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert ....... ticket" + ticket);
		return ticket;
	}
	
}
