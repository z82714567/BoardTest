package com.tenco.bookhub.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardTest {

	private int id;
	private String title;
	private String content;
	private String create_date; 
	private int count;
	
}
