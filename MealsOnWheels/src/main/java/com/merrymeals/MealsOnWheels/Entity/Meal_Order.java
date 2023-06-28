package com.merrymeals.MealsOnWheels.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meal_Order {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ml_id;
	private String meal_details;
	private String date;
	//There was a thing for dates, I dunno how yet
	
	private Long Member;
	private Long Partner;
	private Long Volunteer;
	
	public Meal_Order() {
		
	}

	
	
	public Meal_Order(Long ml_id, String meal_details, String date, Long member, Long partner, Long volunteer) {
		super();
		this.ml_id = ml_id;
		this.meal_details = meal_details;
		this.date = date;
		Member = member;
		Partner = partner;
		Volunteer = volunteer;
	}



	public Long getMl_id() {
		return ml_id;
	}

	public void setMl_id(Long ml_id) {
		this.ml_id = ml_id;
	}

	public String getMeal_details() {
		return meal_details;
	}

	public void setMeal_details(String meal_details) {
		this.meal_details = meal_details;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getMember() {
		return Member;
	}

	public void setMember(Long member) {
		Member = member;
	}

	public Long getPartner() {
		return Partner;
	}

	public void setPartner(Long partner) {
		Partner = partner;
	}

	public Long getVolunteer() {
		return Volunteer;
	}

	public void setVolunteer(Long volunteer) {
		Volunteer = volunteer;
	}
	
	
}
