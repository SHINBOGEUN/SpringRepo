package com.korea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.korea.domain.Board1DTO;
//Mybatis 스프링 연동
public interface TimeMapper {
	
	
	@Select("SELECT sysdate From dual")
	
	public String getTime();
	public String getTime2();
	
	@Select("select * from tbl_board")
	public List<Board1DTO> SelectAll();
}
