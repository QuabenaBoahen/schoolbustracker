package com.rosebrakoh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rosebrakoh.model.Role;
import com.rosebrakoh.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Role findOne(String roleId) {
		return roleRepository.findOne(roleId);
	}

}
