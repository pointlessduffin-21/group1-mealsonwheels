package com.merrymeals.mealsonwheels.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Meal_Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mo_id;
	private Long mem_id;
	private Long vol_id;
	private Long part_id;
	private Long meal_id;
	private LocalDateTime dateTime;
	private LocalDateTime dateDelivered;
	private String order_status;
	
	public Meal_Order() {
		
	}

	public Meal_Order(Long mo_id, Long mem_id, Long vol_id, Long part_id, Long meal_id, LocalDateTime dateTime,
			LocalDateTime dateDelivered, String order_status) {
		super();
		this.mo_id = mo_id;
		this.mem_id = mem_id;
		this.vol_id = vol_id;
		this.part_id = part_id;
		this.meal_id = meal_id;
		this.dateTime = dateTime;
		this.dateDelivered = dateDelivered;
		this.order_status = order_status;
	}

	public Long getMo_id() {
		return mo_id;
	}

	public void setMo_id(Long mo_id) {
		this.mo_id = mo_id;
	}

	public Long getMem_id() {
		return mem_id;
	}

	public void setMem_id(Long mem_id) {
		this.mem_id = mem_id;
	}

	public Long getVol_id() {
		return vol_id;
	}

	public void setVol_id(Long vol_id) {
		this.vol_id = vol_id;
	}

	public Long getPart_id() {
		return part_id;
	}

	public void setPart_id(Long part_id) {
		this.part_id = part_id;
	}

	public Long getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(Long meal_id) {
		this.meal_id = meal_id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public LocalDateTime getDateDelivered() {
		return dateDelivered;
	}

	public void setDateDelivered(LocalDateTime dateDelivered) {
		this.dateDelivered = dateDelivered;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	@Override
	public String toString() {
		return "Meal_Order [mo_id=" + mo_id + ", mem_id=" + mem_id + ", vol_id=" + vol_id + ", part_id=" + part_id
				+ ", meal_id=" + meal_id + ", dateTime=" + dateTime + ", dateDelivered=" + dateDelivered
				+ ", order_status=" + order_status + "]";
	}
	
	
	

}
