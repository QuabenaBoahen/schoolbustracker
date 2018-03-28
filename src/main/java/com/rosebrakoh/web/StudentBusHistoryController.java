package com.rosebrakoh.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rosebrakoh.model.StudentBusHistory;
import com.rosebrakoh.service.StudentBusHistoryService;

@RestController
public class StudentBusHistoryController {
		
	@Autowired
	private StudentBusHistoryService studentBusHistoryService;
	
	@GetMapping("/get-bus-boarding")
	public List<StudentBusHistory> getBusBordingistory(){
		return studentBusHistoryService.getBusBordingistory();
	}
	
	@PostMapping("/save-bus-boarding")
	public List<StudentBusHistory> saveBusBordingistory(@RequestBody List<StudentBusHistory> studentBusHistory){
		return studentBusHistoryService.saveBusBordingistory(studentBusHistory);
	}

}
