package com.korea.controller;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.korea.sample.TestDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class log4j {
	@Autowired
	private TestDTO dto;
	@Test
	public void test() {
		
		
		dto.setName("하하");
		dto.setAge("33");
		dto.setAddr("addr");
		log.info("dto info : "+dto.toString());
		
	}

}
