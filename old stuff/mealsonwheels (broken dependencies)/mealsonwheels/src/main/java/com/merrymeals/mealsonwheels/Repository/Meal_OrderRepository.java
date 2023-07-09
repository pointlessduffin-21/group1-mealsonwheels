package com.merrymeals.mealsonwheels.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.merrymeals.mealsonwheels.Entity.Meal_Order;

@Repository
public interface Meal_OrderRepository extends JpaRepository<Meal_Order, Long> {

}
