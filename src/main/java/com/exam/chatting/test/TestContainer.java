package com.exam.chatting.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestContainer {
	
	@GetMapping("/test")
	public String test() {
		return "thymeleaf/sample";
	}

}
