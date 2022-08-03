package com.korea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.korea.domain.BoardDTO;

public interface BoardMapper {
	
	@Select("select * from tblboard where bno >0")
	public List<BoardDTO> getList();
	
	public List<BoardDTO> getListXML();
	
	public void insertXML(BoardDTO board);
	
	
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
	
}
