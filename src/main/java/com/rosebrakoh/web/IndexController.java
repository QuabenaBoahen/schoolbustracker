package com.rosebrakoh.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
