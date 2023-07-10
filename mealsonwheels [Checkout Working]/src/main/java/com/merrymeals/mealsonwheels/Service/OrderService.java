package com.merrymeals.mealsonwheels.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merrymeals.mealsonwheels.Entity.Meal;
import com.merrymeals.mealsonwheels.Entity.Meal_Order;
import com.merrymeals.mealsonwheels.Repository.OrderRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	OrderRepository orderRepo;

	public void save(Meal_Order order) {
		orderRepo.save(order);
	}
	public Meal_Order getOrder(Long id) {
		return orderRepo.findById(id).get();
	}
	
	public String getLastOrderNumber() {
		return orderRepo.getLastOrderNumber();
	}
	public List<Meal_Order> getMealsByUId(Long u_id) {
		// TODO Auto-generated method stub
		return orderRepo.getMealsByUId(u_id);
	}
	
	public Meal_Order getAcceptedOrders(Long orderId) {
		return orderRepo.getAcceptedOrders(orderId);
	}
	
	public List<Meal_Order> getOrdered() {

		return orderRepo.getOrdered();
	}
	
	public List<Meal_Order> getApproved() {

		return orderRepo.getApproved();
	}
	
	public List<Meal_Order> getAccepted() {

		return orderRepo.getAccepted();
	}
	public List<Meal_Order> getCooked() {

		return orderRepo.getCooked();
	}
}
