package com.example.swiggy.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swiggy.dao.*;
import com.example.swiggy.entity.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryPartnerController {

	@Autowired
	FoodOrderRepo or;
	
	@GetMapping("/orders/{partnerid}")
	public List<FoodOrder> myorders(@PathVariable int partnerid)
	{
		
		return or.findByDeliveryPartner_Id(partnerid);
	}
	
	@PutMapping("/status/{orderid}")
	public FoodOrder updatests(@PathVariable int orderid)
	{
		FoodOrder order=or.findById(orderid).get();
		order.setStatus(OrderStatus.DELIVERED);
		return or.save(order);
	}
	
	
	
}
