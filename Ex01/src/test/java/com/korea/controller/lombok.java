package com.korea.controller;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.korea.sample.TestDTO;

public class lombok {

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		TestDTO hong = new TestDTO("윤혜지", "26","대구");
		System.out.println(hong.toString());
		
		TestDTO obj1 = TestDTO.builder()
					.age("34")
					.name("박경덕")
					.addr("칠곡")
					.build();
		
		System.out.println(obj1.toString());
		
	}

}
