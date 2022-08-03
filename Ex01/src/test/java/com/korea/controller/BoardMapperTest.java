package com.korea.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.korea.domain.BoardDTO;
import com.korea.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
//		mapper.getList().forEach(board->log.info(board));
		
//		mapper.getListXML().forEach(board->log.info(board));
		
//		BoardDTO dto = new BoardDTO();
//		dto.setTitle("새로 작성하는 글3");
//		dto.setContent("새로작성하는 내용3");
//		dto.setWriter("작성자3");
//		
//		long bno = mapper.insertSelectKey(dto);
		
//		BoardDTO dto = mapper.readXML(20L);
//		log.info(dto);
		
//		int result = mapper.deleteXML(101L);
//		log.info(result);
		
		//Update
		BoardDTO dto = new BoardDTO();
		dto.setBno(98L);
		dto.setTitle("수정 제목1");
		dto.setContent("수정 내용1");
		dto.setWriter("수정된 작성자1");
		
		
		mapper.updateXML(dto);
	}
	
}
