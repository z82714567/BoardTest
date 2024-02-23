package com.tenco.bookhub.web.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContorller {

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
}
