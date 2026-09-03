package com.example.swiggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swiggy.dao.*;
import com.example.swiggy.entity.*;
//import com.sun.tools.javac.util.*;
//import com.example.swiggy.dao.*;
@RestController
@RequestMapping("/customer")

public class CustomerController {
	 
	@Autowired
	FoodItemRepo fi1;
	
	@Autowired
	FoodOrderRepo fr1;
	
	@Autowired
	UserRepo ur1;
	
	@GetMapping("/menu")
	public List<FoodItem> showmenu(){
		return fi1.findAll();
	}
	
	@PostMapping("/order/{customerid}")
	public FoodOrder placeorder(@PathVariable int customerid, @RequestBody List<Integer> foodids)
	{
		FoodOrder order = new FoodOrder();
		order.setCustomer(ur1.findById(customerid).get());
		order.setItems(fi1.findAllById(foodids));
		order.setStatus(OrderStatus.PLACED);
		return fr1.save(order);
		
		
	}
	
	
	

}
