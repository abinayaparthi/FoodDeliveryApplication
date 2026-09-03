package com.example.swiggy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.swiggy.entity.*;
import com.example.swiggy.dao.*;
@Service

public class customerUserDetailsService implements UserDetailsService
{

	@Autowired
	UserRepo p;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	    User u = p.findByName(username)
	            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

	    return org.springframework.security.core.userdetails.User
	    		.builder()
	            .username(u.getName())
	            .password(u.getPassword())
	            .roles(u.getRole().name())
	            .build();
	}

	

}
