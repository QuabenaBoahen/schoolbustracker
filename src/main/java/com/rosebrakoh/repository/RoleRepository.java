package com.rosebrakoh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rosebrakoh.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>{
	
	Role findByName(String roleName);

}
