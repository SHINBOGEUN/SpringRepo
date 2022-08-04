package com.korea.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.korea.domain.BoardDTO;
import com.korea.domain.Criteria;
import com.korea.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
//	@Test
//	public void testgetListWithPaging() {
//		Criteria cri = new Criteria();
//		List<BoardDTO> list = mapper.getListWithPaging(cri);
//		list.forEach(board -> log.info(board));
//	}
	@Test
	public void test() {
		Map<String, Object> map = new HashMap();
		map.put("type", "T");
		map.put("title", "sadfsdf");
		map.put("content", "수정");
		map.put("writer", "TEST");
		mapper.test(map);
		
	}
}
