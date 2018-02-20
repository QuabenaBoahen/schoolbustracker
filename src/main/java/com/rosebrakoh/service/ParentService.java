package com.rosebrakoh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rosebrakoh.model.Parent;
import com.rosebrakoh.repository.ParentRepository;

@Service
public class ParentService {
	
	@Autowired
	private ParentRepository parentRepository;
	
	public Iterable<Parent> findAll(){
		return parentRepository.findAll();
	}

}
