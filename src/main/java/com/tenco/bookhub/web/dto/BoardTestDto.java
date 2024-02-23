package com.tenco.bookhub.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardTestDto {

	private String title;
	private String content;
	private int count;
}
