package com.tenco.bookhub.web.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserPageController {

	// 회원가입 : form
	@GetMapping("/signup") 
	public String signUp() {
		return "auth/signup";
	}
	
	
	@GetMapping("/signup2") 
	public String signUp2() {
		return "auth/signup2";
	}
	
	// 로그인 : form
	@GetMapping("/signin")
	public String signIn() {
		return "auth/signin";
	}
	@GetMapping("/signin2")
	public String signIn2() {
		return "auth/signin2";
	}
	
	
}
