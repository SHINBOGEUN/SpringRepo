package com.korea.controller;
import java.util.List;
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
   @Test
   public void getListTest() {
      List<BoardDTO> list = mapper.getList();
      for(BoardDTO BoardDTO : list) {
         log.info(BoardDTO.toString());
      }
   }
   @Test
   public void insertTest() {   
      BoardDTO vo = new BoardDTO();
      vo.setTitle("신보근 시험1");
      vo.setContent("신보근 시험1");
      vo.setWriter("신보근 시험1");
      mapper.insert(vo);
      log.info("생성하신 값은 : " + vo);
   }
   @Test
   public void readTest() {
      log.info(mapper.read(111L));
   }
   @Test
   public void DeleteTest() {
      int result = mapper.delete(112L);
        log.info("결과 : .................." + result);
   }
   @Test
   public void UpdateTest() {
      BoardDTO vo = new BoardDTO();
      vo.setBno(112L);
      vo.setTitle("신보근수정");
      vo.setContent("신보근수정");
      vo.setWriter("신보근수정");
      mapper.update(vo);
   }
   @Test
   public void getTotalCountTest() {
      Criteria cri = new Criteria();
        /* 검색조건 */
        cri.setKeyword("테스트");
        /* 게시글 총 갯수 */
        int result = mapper.getTotalCount(cri);
        System.out.println("게시글 총 개수" + result);

   }
   
}





