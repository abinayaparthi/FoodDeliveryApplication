package com.example.swiggy.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swiggy.entity.*;
public interface FoodItemRepo extends JpaRepository<FoodItem,Integer> {

}
