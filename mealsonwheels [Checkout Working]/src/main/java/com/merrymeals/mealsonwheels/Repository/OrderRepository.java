package com.merrymeals.mealsonwheels.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.merrymeals.mealsonwheels.Entity.Meal;
import com.merrymeals.mealsonwheels.Entity.Meal_Order;

@Repository
public interface OrderRepository extends JpaRepository<Meal, Long>{

	void save(Meal_Order order);


	@Query("SELECT o FROM Meal_Order o WHERE o.m_id = :mealId")
	public Long getMealIdById(@Param("mealId") Long mealId);
	
	@Query(value = "SELECT user_details_id, first_name, last_name, title, about, phone_number, address, city, country FROM meal_order"
			+ " JOIN meal ON meal_order.m_id = meal.m_id"
			+ " WHERE meal.m_id = :mealId", nativeQuery = true)
	public String getDetailsById(@Param("mealId") String userId);
	
	@Query(value = "SELECT order_number FROM Meal_Order ORDER BY mo_id DESC LIMIT 1")
	public String getLastOrderNumber();
	
}
