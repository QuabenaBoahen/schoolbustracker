package com.rosebrakoh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rosebrakoh.model.StudentBusHistory;
import com.rosebrakoh.repository.StudentBusHistoryRepository;

@Service
public class StudentBusHistoryService {
	private static final Logger log = LoggerFactory.getLogger(StudentBusHistoryService.class);
	
	@Autowired
	private StudentBusHistoryRepository studentBusHistoryRepository;
	
	public List<StudentBusHistory> getBusBordingistory(){
		return studentBusHistoryRepository.findAll();
	}
	
	public List<StudentBusHistory> getBusBordingistoryForToday(String date){
		List<StudentBusHistory> busHistory = new ArrayList<>();
		if(!studentBusHistoryRepository.findAll().isEmpty()) {
		for(StudentBusHistory history: studentBusHistoryRepository.findAll()) {
			String dateToCompare = history.getDate().substring(0, 10);
			if(dateToCompare.contentEquals(date)) {
				busHistory.add(history);
			}
		   }
		}
		return busHistory;
	}
	
	public List<StudentBusHistory> saveBusBordingistory(List<StudentBusHistory> studentBusHistory){
		Date date = new Date();
		List<StudentBusHistory> history = new ArrayList<>();
		if(studentBusHistory.isEmpty()) {
		   return null;
		}
		/*
		 * check if any item in the coming list is NOT already saved before saving
		 * -- first make sure bus boarding record is not empty
		 */
		if(!studentBusHistoryRepository.findAll().isEmpty()) {
			String todaysDate = date.toString().substring(0, 10);
			log.info("eclipse " + todaysDate);
			for(int i=0;i<studentBusHistory.size();i++) {
				for(int j=0;j<studentBusHistoryRepository.findAll().size();j++) {
					log.info("android " + studentBusHistory.get(i).getDate().substring(0, 10));
			 if(!studentBusHistory.get(i).getStudentId().equals(studentBusHistoryRepository.findAll().get(j).getStudentId())
			 || !studentBusHistory.get(i).getDate().substring(0, 10).equals(todaysDate)) {
				   log.info("At least one bus history record exists already");
				    if(studentBusHistoryRepository.findByStudentId(studentBusHistory.get(i).getStudentId())==null ||
				    		!studentBusHistory.get(i).getDate().substring(0, 10).equals(todaysDate)) {
				    	studentBusHistory.get(i).setDate(date.toString());
				    	history.add(studentBusHistory.get(i));
				    }
			       }
				}
			}
			log.info("Saving bus boarding history [ Adding to existing records ] ...");
			studentBusHistoryRepository.save(history);
		}else {
			history=studentBusHistory;
			log.info("Saving bus boarding history for the first time...");
		    for(StudentBusHistory h: history) {
		    	h.setDate(date.toString());
		    }
			studentBusHistoryRepository.save(history);
		}
		return history;
	}

}
