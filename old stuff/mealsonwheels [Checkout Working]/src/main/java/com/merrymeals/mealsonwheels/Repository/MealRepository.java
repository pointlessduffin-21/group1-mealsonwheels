package com.merrymeals.mealsonwheels.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.merrymeals.mealsonwheels.Entity.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long>{
	@Query("SELECT m FROM Meal m WHERE m.meal_name LIKE %:key%")
	public List<Meal> search(@Param("key") String key);

	@Query("SELECT m FROM Meal m WHERE m.m_id = :mealId")
	public Meal getCartOrders(@Param("mealId") Long mealId);
	
	@Query("SELECT o FROM Meal o WHERE o.m_id = :mealId")
	public Long getMealIdById(@Param("mealId") Long mealId);
}