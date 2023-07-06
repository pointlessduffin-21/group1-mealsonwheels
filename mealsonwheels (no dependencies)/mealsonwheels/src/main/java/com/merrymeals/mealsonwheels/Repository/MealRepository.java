package com.merrymeals.mealsonwheels.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.merrymeals.mealsonwheels.Entity.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long>{
	@Query("SELECT m FROM Meal m WHERE m.meal_name LIKE %:key%"
			+ " OR m.ingredients LIKE %:key%"
			+ " OR m.nutrition LIKE %:key%")
	public List<Meal> search(@Param("key") String key);
}