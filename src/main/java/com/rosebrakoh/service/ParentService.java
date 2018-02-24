package com.rosebrakoh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rosebrakoh.model.Parent;
import com.rosebrakoh.model.Role;
import com.rosebrakoh.model.User;
import com.rosebrakoh.repository.ParentRepository;
import com.rosebrakoh.repository.RoleRepository;

@Service
public class ParentService {
	
	@Autowired
	private ParentRepository parentRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserService userService;
	
	public Iterable<Parent> findAll(){
		return parentRepository.findAll();
	}
	
	public String save(Parent parent) {
		Role role = roleRepository.findByName("ROLE_PARENT");
		Parent p = parentRepository.save(parent);
		User user = new User(p.getId(), parent.getUser().getUsername(), 
				parent.getUser().getPassword());
		user.setRole(role);
		userService.save(user);
		return "redirect:/parents";
	}

}
