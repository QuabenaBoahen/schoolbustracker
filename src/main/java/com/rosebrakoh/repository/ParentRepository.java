package com.rosebrakoh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rosebrakoh.model.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, String>{

}
