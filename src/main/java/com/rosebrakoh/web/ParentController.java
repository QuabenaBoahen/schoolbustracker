package com.rosebrakoh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rosebrakoh.model.Parent;
import com.rosebrakoh.service.ParentService;

@Controller
public class ParentController {
	
	@Autowired
	private ParentService parentService;
	
	@GetMapping("/parents")
	public String allParents(Model model) {
		model.addAttribute("parent", new Parent());
		model.addAttribute("parents", parentService.findAll());
		return "parents";
	}
	
	@PostMapping("/parents")
	public String saveParent(Parent parent) {
		return parentService.save(parent);
	}

}
