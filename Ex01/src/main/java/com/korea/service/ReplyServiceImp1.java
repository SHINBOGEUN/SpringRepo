package com.korea.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.domain.Criteria;
import com.korea.domain.ReplyDTO;
import com.korea.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImp1 implements ReplyService{
	private ReplyMapper mapper;
	
	
	
	@Override
	public int register(ReplyDTO dto) {
		log.info("Register.." + dto);
		return mapper.insert(dto);
	}

	@Override
	public ReplyDTO get(Long rno) {
		log.info("Get...." + rno);
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyDTO dto) {
		log.info("modify ..." + dto);
		return mapper.update(dto);
	}

	@Override
	public int remove(Long rno) {
		log.info("remove...." + rno);
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyDTO> getList(Criteria cri, Long bno) {
		log.info("get reply List of a Board" + bno);
		return mapper.getListWithPaging(cri, bno);
	}

}
