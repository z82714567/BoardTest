package com.tenco.bookhub.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
	
	
	private int id;
	private String username;
	private String name;
	private String password;
	private int phone;
	private String create_date;

}
