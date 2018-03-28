package com.rosebrakoh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rosebrakoh.model.StudentBusHistory;

@Repository
public interface StudentBusHistoryRepository extends JpaRepository<StudentBusHistory, String>{
	
	List<StudentBusHistory> findAllByDate(String date);
	
	StudentBusHistory findByStudentId(String studentId);

}
