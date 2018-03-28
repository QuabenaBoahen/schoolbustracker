package com.rosebrakoh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rosebrakoh.model.Parent;
import com.rosebrakoh.model.Student;
import com.rosebrakoh.model.User;
import com.rosebrakoh.repository.ParentRepository;
import com.rosebrakoh.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ParentRepository parentRepository;
	
	@Autowired
	private UserService userService;
	
	public Iterable<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public Student findById(String studentId) {
		return studentRepository.findOne(studentId);
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public String save(Student student) {
		User parentUser = userService.findByUsername(student.getParent().getUser().getUsername());
		Parent  parent = parentRepository.findOne(parentUser.getUserId());
		student.setParent(parent);
		studentRepository.save(student);
		return "redirect:/";
	}

}
