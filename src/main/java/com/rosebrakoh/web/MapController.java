package com.rosebrakoh.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rosebrakoh.service.StudentBusHistoryService;

@Controller
public class MapController {
	@Autowired
	private StudentBusHistoryService studentBusHistoryService;
	
	@GetMapping("/map")
	public String showMap(Model model) {
		Date date = new Date();
		String d = date.toString().substring(0, 10);
		model.addAttribute("busHistory", studentBusHistoryService.getBusBordingistoryForToday(d));
		return "map";
	}

}
