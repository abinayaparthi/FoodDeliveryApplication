package com.example.swiggy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swiggy.dao.*;
import com.example.swiggy.entity.*;
//import com.example.swiggy.dao.*;
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserRepo ar1;
	@Autowired
	RestRepo ar2;
	@Autowired
	FoodItemRepo ar3;
	@Autowired
	FoodOrderRepo ar4;
	
	@PostMapping("/addrest")
	public Restaurant get1(@RequestBody Restaurant r) {
		return ar2.save(r);
	}
	
	@PostMapping("/addfood")
	public FoodItem get2(@RequestBody FoodItem fi) {
		return ar3.save(fi);
	}
	
	@PutMapping("/assign/{orderid}/{partnerid}")
	public FoodOrder get3(@PathVariable int orderid, @PathVariable int partnerid) {
		FoodOrder order = ar4.findById(orderid).get();
		User partner =ar1.findById(partnerid).get();
		
		order.setDeliveryPartner(partner);
		order.setStatus(OrderStatus.OUT_OF_DELIVERY);
		return ar4.save(order);
		
	}
	
}
