package com.rosebrakoh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosebrakoh.model.User;
import com.rosebrakoh.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {	
		return userRepository.save(user);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public Integer countParentsWithUsername(String username) {
		return userRepository.findAllByUsername(username).size();
	}
	
	public User findUserById(String id) {
		return userRepository.findOne(id);
	}

}
