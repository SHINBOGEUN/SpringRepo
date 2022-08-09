package com.korea.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestSampleDTO {
	private Integer mno;
	private String firstName;
	private String lastName;
}
