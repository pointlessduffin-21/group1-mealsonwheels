package com.merrymeals.mealsonwheels.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merrymeals.mealsonwheels.Entity.Meal;
import com.merrymeals.mealsonwheels.Entity.Meal_Order;
import com.merrymeals.mealsonwheels.Repository.MealRepository;
import com.merrymeals.mealsonwheels.Repository.Meal_OrderRepository;

@Service
@Transactional
public class MealService {

	@Autowired
	MealRepository mealRepo;
	
	@Autowired
	Meal_OrderRepository mor;
	
	
//	Meal Repo
public void save(Meal meal) {
	mealRepo.save(meal);
}

	public Meal get(Long id) {
		return mealRepo.findById(id).get();
	}

	public void delete(Long id) {
		mealRepo.deleteById(id);
	}
	public List<Meal> search(String key) {
		return mealRepo.search(key);
	}

	public List<Meal> getAllMeals() {
		return mealRepo.findAll();
	}
	
//	Meal Order Repo
	
	public void saveOrder(Meal_Order order) {
		mor.save(order);
	}
	
	public Meal_Order getOrder(Long id) {
		return mor.findById(id).get();
	}
	
	public void deleteOrder(Long id) {
		mor.deleteById(id);
	}
	
	public List<Meal_Order> listOrders(){
		return mor.findAll();
	}
}
