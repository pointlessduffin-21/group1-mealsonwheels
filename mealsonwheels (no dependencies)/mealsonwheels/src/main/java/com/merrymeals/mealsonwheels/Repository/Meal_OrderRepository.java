package com.merrymeals.mealsonwheels.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.merrymeals.mealsonwheels.Entity.Meal_Order;


@Repository
public interface Meal_OrderRepository extends JpaRepository<Meal_Order, Long> {

	
	@Query("SELECT mo FROM Meal_0rder m WHERE mo.order_status LIKE :ForApproval")
	public List<Meal_Order> forApprovalList();
	
	@Query("SELECT mo FROM Meal_0rder m WHERE mo.order_status LIKE :ToCook")
	public List<Meal_Order> toCookList();
	
	@Query("SELECT mo FROM Meal_0rder m WHERE mo.order_status LIKE :ForDelivery")
	public List<Meal_Order> forDeliveryList();
	
	@Query("SELECT mo FROM Meal_0rder m WHERE mo.order_status LIKE :Delivered")
	public List<Meal_Order> deliveredList();
	
}
