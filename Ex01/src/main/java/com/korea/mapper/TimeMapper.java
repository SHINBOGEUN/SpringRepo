package com.korea.mapper;

import org.apache.ibatis.annotations.Select;
//Mybatis 스프링 연동
public interface TimeMapper {
	
	
	@Select("SELECT sysdate From dual")
	
	public String getTime();
	public String getTime2();
}
