package com.rosebrakoh.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rosebrakoh.model.Role;
import com.rosebrakoh.model.User;
import com.rosebrakoh.repository.RoleRepository;
import com.rosebrakoh.repository.UserRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User with the username " + username + 
					" wasn't found");
		}

		return new org.springframework.security.core.userdetails.User(
	              user.getUsername(), user.getPassword(), user.isEnabled(),
	              user.isAccountNonExpired(), user.isCredentialsNonExpired(), user.isAccountNonLocked(), 
	              getAuthorities(user.getRole().getId()));
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(String roleId) {
		Role role=roleRepository.findOne(roleId);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(role.getName()));	
        return authorities;
    }

}
