package com.rosebrakoh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rosebrakoh.model.Student;
import com.rosebrakoh.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Iterable<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public Student save(Student student) {
		return studentRepository.save(student);
	}

}
