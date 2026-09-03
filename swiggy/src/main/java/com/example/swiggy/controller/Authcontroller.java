package com.example.swiggy.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.example.swiggy.entity.*;
import com.example.swiggy.dao.*;

@RestController
@RequestMapping("/auth")//common link
public class Authcontroller {
	
	@Autowired
	UserRepo r1;

	@PostMapping("/register")//"/auth/register"
	public User reg(@RequestBody User u) {
		return r1.save(u);
	}
	
	
}
