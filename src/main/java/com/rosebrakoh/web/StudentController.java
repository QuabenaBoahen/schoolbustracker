package com.rosebrakoh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rosebrakoh.model.Student;
import com.rosebrakoh.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
   
	@GetMapping("/students")
	public String viewStudents(Model model) {
		model.addAttribute("students", studentService.findAll());
		model.addAttribute("student", new Student());
		return "students";
	}
	
	@PostMapping("/students")
	public String addStudent(Student student) {
		studentService.save(student);
		return "redirect:/students";
	}
}
