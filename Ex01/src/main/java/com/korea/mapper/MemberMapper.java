package com.korea.mapper;

import com.korea.domain.MemberDTO;

public interface MemberMapper {
	
	//맴버 조회
	public MemberDTO read(String userid);
}
