package com.tenco.bookhub.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequestDto {

	private String username;
	private String name;
	private String password;
	private int phone;
	
}
