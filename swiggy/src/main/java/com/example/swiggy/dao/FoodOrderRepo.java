package com.example.swiggy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swiggy.entity.FoodOrder;

public interface FoodOrderRepo extends JpaRepository<FoodOrder, Integer> {

    List<FoodOrder> findByDeliveryPartner_Id(Integer id);

}