package com.rosebrakoh.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rosebrakoh.model.Student;
import com.rosebrakoh.model.User;
import com.rosebrakoh.service.StudentService;
import com.rosebrakoh.service.UserService;

@RestController
public class AjaxController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value="/verify-parent-username")
	public int verifyParentUsername(@RequestParam(value="username", required=false) String username) {
		return userService.countParentsWithUsername(username);
	}
	
	@GetMapping(value="/get-parent-username")
	public String getParentUsername(@RequestParam(value="id", required=false) String id) {
		return userService.findUserById(id).getUsername();
	}
	
	/*
	 * APIs for android consumption
	 */
	
	@GetMapping("/all-students")
	public List<Student> getAll(){
		return studentService.getAllStudents();
	}
	
	@PostMapping("/authenticate")
	public User authenticateUser(@RequestBody User user) {
		User u=userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(u==null) {
			return null;
		} 
		return u;
	}

}
