package com.Group1.MealsOnWheels.controller;

import java.util.List;

import com.Group1.MealsOnWheels.Entity.Meal_Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Group1.MealsOnWheels.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/pendingOrders")
    public ResponseEntity<List<Meal_Order>> getAllOrders() {
        List <Meal_Order> allOrders = orderRepository.findByStatus("ORDERED");
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }
}
