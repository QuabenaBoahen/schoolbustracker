package com.rosebrakoh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rosebrakoh.service.StudentBusHistoryService;

@Controller
public class IndexController {
	
	@Autowired
	private StudentBusHistoryService studentBusHistoryService;
	
	@GetMapping("/")
	public String index() {
		return "map";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/bus-boarding-history")
	public String busBordingistory(Model model){
		model.addAttribute("busHistory", studentBusHistoryService.getBusBordingistory());
		return "bus-history";
	}
	
	@GetMapping("/403_error")
	public String _403() {
		return "403";
	}

}
