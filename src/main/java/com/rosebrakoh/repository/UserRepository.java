package com.rosebrakoh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rosebrakoh.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	public User findByUsername(String username);
	
	@Query(value = "SELECT * FROM user WHERE username = ?1 AND is_verified = 1", nativeQuery = true)
	User findUserByUsername(String username);

}
