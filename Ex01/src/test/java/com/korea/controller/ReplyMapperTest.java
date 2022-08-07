package com.korea.controller;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.korea.domain.Criteria;
import com.korea.domain.ReplyDTO;
import com.korea.mapper.ReplyMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTest {
	@Autowired
	private ReplyMapper mapper;
	
	private Long[] bnoArr = { 7L, 8L, 9L, 10L, 11L };
	
	
	@Test
	public void testMapper() {
		IntStream.rangeClosed(1, 10).forEach(i->{
			ReplyDTO dto = new ReplyDTO();
			
			//게시물의 번호
			dto.setBno(bnoArr[i%5]);
			dto.setReply("댓글테스트" + i);
			dto.setReplyer("replyer" + i);
			
			mapper.insert(dto);
		});
	}
	
	@Test
	public void ReadTest() {
		ReplyDTO dto = mapper.read(1L);
		log.info("read : " + dto);
	}
	
	@Test
	public void UpdateTest() {
		ReplyDTO dto = mapper.read(1L);
		dto.setReply("UpdateTest");
		int count = mapper.update(dto);
		log.info("UPDATE COUNT : " + count);
	}
	
	@Test
	public void CreateReply2() {
		long bnolist[] = {4L,5L,6L};
		ReplyDTO dto = new ReplyDTO();
		for (int i = 0; i < bnolist.length; i++) {
			for (int j = 0; j < 5; j++) {
				dto.setBno(bnolist[i]);
				dto.setReply("테스트" + i);
				dto.setReplyer("작성자" +i);
				mapper.insert(dto);
			}
		}
	}
	@Test
	public void getListPage() {
		Criteria cri = new Criteria();
		List<ReplyDTO> replies = mapper.getListWithPaging(cri, 12L);
		replies.forEach(reply -> log.info(reply));
	}
	
	
}
