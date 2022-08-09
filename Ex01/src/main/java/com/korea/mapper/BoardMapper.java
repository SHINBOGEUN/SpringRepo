package com.korea.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.korea.domain.BoardDTO;
import com.korea.domain.Criteria;

public interface BoardMapper {
	
	@Select("select * from tblboard where bno >0")
	public List<BoardDTO> getList();
	
	public List<BoardDTO> getListXML();
	
	
	public void insertXML(BoardDTO board);
	
	//복수 Param(HashMap)
	public int test(Map<String, Object> map);
	
	
	//복수Param(DTOclass dto)
//	public void test(BoardDTO dto);
	
	
	//복수 Param(@Param("파라미터명") 자료형 파라미터명
//	public void test(@Param("param1") String p1, @Param("param2")String p2, @Param("param3") int p3);
	
	//포함 문자 검색(오라클)
//	public List<BoardDTO> test(String content);
	
	//단일 파라미터 적용
//	public List<BoardDTO> test(@Param("bno") int bno);
	
//	public List<BoardDTO> test();
	
	@SelectKey(statement="select seq_board.currval from dual",
			keyProperty = "bno",
			before = false,
			resultType=long.class)
	@Insert
	("insert into tblboard(bno,title,content,writer) values(seq_board.nextval,#{title},#{content},#{writer})")
	public long insertSelectKey(BoardDTO dto);
	
	
	@Insert
	("insert into tblboard(bno,title,content,writer) values(seq_board.nextval,#{title},#{content},#{writer})")
	public void insert(BoardDTO dto);
	
	@Select("select * from tblboard where bno=#{bno}")
	public BoardDTO read(Long bno);
	
	@Select("select * from tblboard where bno=#{bno}")
	public BoardDTO readXML(Long bno);
	
	@Delete("delete from tblboard where bno=#{bno}")
	public int delete (Long bno);
	
	public int deleteXML (Long bno);
	
	@Update
	("update tblboard set title=#{title},content=#{content}, writer=#{writer}, updateDate=sysdate where bno = #{bno}")
	public int update(BoardDTO dto);
	
	public int updateXML(BoardDTO dto);
	
	
	
	public List<BoardDTO> getListWithPaging(Criteria cri);
	
	
	
	@Select("select count(*) from tblboard where bno>0")
	public int getTotalCount(Criteria cri);
}
