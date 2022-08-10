package com.korea.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.korea.domain.CustomUser;
import com.korea.domain.MemberDTO;
import com.korea.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{

	
	@Autowired
	private MemberMapper memberMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("Load User By UserName : " + username);
		
		MemberDTO dto = memberMapper.read(username);
		log.warn("querid by member mapper : " + dto);
		return dto == null ? null : new CustomUser(dto);
	}

}
