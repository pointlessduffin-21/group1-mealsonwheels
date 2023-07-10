package com.merrymeals.mealsonwheels.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.merrymeals.mealsonwheels.Entity.Meal;
import com.merrymeals.mealsonwheels.Entity.Meal_Order;

@Repository
public interface OrderRepository extends JpaRepository<Meal_Order, Long>{

	@Query("SELECT o FROM Meal_Order o WHERE o.m_id = :mealId")
	public Long getMealIdById(@Param("mealId") Long mealId);

//	@Query(value = "SELECT user_details_id, first_name, last_name, title, about, phone_number, address, city, country FROM meal_order"
//			+ " JOIN meal ON meal_order.m_id = meal.m_id"
//			+ " WHERE meal.m_id = :mealId", nativeQuery = true)
//	public String getDetailsById(@Param("mealId") String userId);

	@Query("SELECT o, m.meal_name FROM Meal_Order o JOIN Meal m ON o.m_id = m.m_id WHERE o.u_id = :userId")
	public List<Meal_Order> getMealsByUId(@Param("userId") Long userId);

	@Query("SELECT o FROM Meal_Order o WHERE o.v_id = :volunteerId and o.status = :status")
	public List<Meal_Order> getOrdersByVIdAndStatus(@Param("volunteerId") Long volunteerId, @Param("status") String status);

	@Query(value = "SELECT order_number FROM Meal_Order ORDER BY mo_id DESC LIMIT 1",
			nativeQuery = true)
	public String getLastOrderNumber();
	
	@Query(value = "SELECT o FROM Meal_Order m WHERE o.mo_id = :orderId",
			nativeQuery = true)
	public Meal_Order getAcceptedOrders(@Param("orderId") Long orderId);

	@Query("SELECT mo FROM Meal_Order mo WHERE mo.status = 'ORDERED'")
	public List<Meal_Order> getOrdered();

	@Query("SELECT mo FROM Meal_Order mo WHERE mo.status  = 'APPROVED'")
	public List<Meal_Order> getApproved();
	
	@Query("SELECT mo FROM Meal_Order mo WHERE mo.status  = 'ACCEPTED'")
	public List<Meal_Order> getAccepted();

	@Query("SELECT mo FROM Meal_Order mo WHERE mo.status  = 'COOKED'")
	public List<Meal_Order> getCooked();

	@Query("SELECT mo FROM Meal_Order mo WHERE mo.status  = 'DELIVERED'")
	public List<Meal_Order> getDelivered();

	@Query("SELECT mo FROM Meal_Order mo WHERE mo.status = :status")
	List<Meal_Order> findByStatus(@Param("status") String status);

	@Query("SELECT mo FROM Meal_Order mo WHERE mo.mo_id = :orderNumber")
	Meal_Order findByOrderNumber(String orderNumber);

}
