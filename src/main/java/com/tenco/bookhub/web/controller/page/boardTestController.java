package com.tenco.bookhub.web.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board/test")
public class boardTestController {

	// 게시판 화면 띄우기
	@GetMapping("/insert")
	public String insert() {
		return "boardTest/insert";
	}

	// 게시판2 화면 띄우기
	@GetMapping("/insert2")
	public String insert2() {
		return "boardTest/insert2";
	}

	// 게시판 조회 화면 띄우기
	@GetMapping("/select")
	public String select() {
		return "boardTest/select";
	}

	// 게시판 조회 화면 띄우기
	@GetMapping("/select2")
	public String select2() {
		return "boardTest/select2";
	}

	// 게시판 상세보기 화면 띄우기
	@GetMapping("/detail/{id}")
	public String detail() {
		return "boardTest/detail";
	}

	// 게시판 수정 띄우기
	@GetMapping("/update/{id}")
	public String update() {
		return "boardTest/update";
	}
	

}
