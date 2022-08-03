package com.korea.domain;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	private String title;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	
	//@DateTimeFormat  >> SimpleDateFormat내포
	private Date date;
}
