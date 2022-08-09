package com.korea.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ticket {
	private int tno;		//번호
	private String owner;	//소유주
	private String grade;	//등급
}
