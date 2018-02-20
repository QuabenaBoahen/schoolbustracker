package com.rosebrakoh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rosebrakoh.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{

}
