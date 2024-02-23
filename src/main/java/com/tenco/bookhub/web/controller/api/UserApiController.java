package com.tenco.bookhub.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tenco.bookhub.entity.User;
import com.tenco.bookhub.service.UserService;
import com.tenco.bookhub.web.dto.UserRequestDto;

import jakarta.servlet.http.HttpSession;

/*
 * @Controller는 무조건 페이지를 리턴함
 * 만약 데이터를 리턴하고 싶다면 해당 컨트롤러에 @ResponseBody를 추가해줘야 한다.
 * 
 * @RestController는 무조건 데이터를 리턴한다
 * @RestController가 달린 클래스의 모든 컨트롤러 메서드에는 @ResponseBody가 생략되어 있다(무조건 적용)
 * 
 * */

@Controller // 페이지 반환 ,restController - 데이터 반환
@RequestMapping("/user")
public class UserApiController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession httpSession;

	// 회원가입
	@PostMapping("/signup")
	public String signup(UserRequestDto dto) {

		boolean result = userService.signup(dto);

		if (result == true) {
			return "home";
		}

		return "error";
	}

	// insert, update, delete 요청 시 --> 서비스에게서 리턴 받는 타입은 무조건 boolean이다.
	// 예 ) boolean result = userService.signup(dto);

	// 로그인
	@PostMapping("/signin")
	public String signin(UserRequestDto dto) { // username, password 값 있으니까 dto 그대로 사용함

		// 성공 여부라서 boolean 사용하기 -- 보기 편하니까  
		boolean result = userService.signin(dto);

		if (result == true) { //성공
			return "home";
		}

		return "error"; //실패

	}

	@PostMapping("/get-session") //header.js
	@ResponseBody // 데이터도 리턴해주기 위해서 사용 (그냥 @컨트롤러는 페이지만 리턴하기 때문에) 
	public User getSession() {
		
		// 세션에서 USER 객체를 가져와서 리턴해 줘야 한다.
		// 1. 세션을 쓰기 위해서는 HttpSession 객체를 DI 한다.
		// 2. 세션에서 user 정보 가져오기 (서비스에서 set해준 User) --> 담기
		// 3. 유저가 null이 아니면 유저정보를 리턴해줌
		User user = (User) httpSession.getAttribute("user"); // 다운캐스팅

		if (user != null) {
			return user;
		}

		return null;
	}

}
