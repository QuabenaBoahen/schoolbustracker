package com.rosebrakoh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rosebrakoh.service.UserService;

@RestController
public class AjaxController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/verify-parent-username")
	public int verifyParentUsername(@RequestParam(value="username", required=false) String username) {
		return userService.countParentsWithUsername(username);
	}
	
	@GetMapping(value="/get-parent-username")
	public String getParentUsername(@RequestParam(value="id", required=false) String id) {
		return userService.findUserById(id).getUsername();
	}

}
