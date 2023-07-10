package com.merrymeals.mealsonwheels.Controller;

import java.util.List;

import com.merrymeals.mealsonwheels.Entity.Partner;
import com.merrymeals.mealsonwheels.Repository.PartnerRepository;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.merrymeals.mealsonwheels.Entity.Meal_Order;
import com.merrymeals.mealsonwheels.Repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PartnerRepository partnerRepository;

    @GetMapping("/pendingOrders")
    public ResponseEntity<List<Meal_Order>> getAllOrders() {
        List <Meal_Order> allOrders = orderRepository.findByStatus("ORDERED");
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Meal_Order>> grabAllOrders() {
        List <Meal_Order> allOrders = orderRepository.findAll();
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }

    @GetMapping("/partners")
    public ResponseEntity<List<Partner>> getAllPartners() {
        List<Partner> allPartners = partnerRepository.findAll();
        return new ResponseEntity<>(allPartners, HttpStatus.OK);
    }

    @PostMapping("/acceptOrder")
    public ResponseEntity<?> acceptOrder(@RequestParam String orderNumber, @RequestParam Long partnerId) {
        Meal_Order order = orderRepository.findByOrderNumber(orderNumber);
        if (order != null) {
            order.setPartner_id(partnerId);
            order.setStatus("ACCEPTED");
            orderRepository.save(order);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}