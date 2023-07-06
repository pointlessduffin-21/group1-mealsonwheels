package com.merrymeals.mealsonwheels.Entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long m_id;
	private String meal_name;
	private String ingredients;
	private String nutrition;
	private String p_id;
  
	@Column(nullable = true, length = 64)
	private String photo;
	
	@Column(nullable = true, length = 64)
	private String photoPath;
	

	public Meal() {

	}
	
	public Meal(Long m_id, String meal_name, String ingredients, String nutrition, String p_id, String photo,
			String photoPath) {

		super();
		this.m_id = m_id;
		this.meal_name = meal_name;
		this.ingredients = ingredients;
		this.nutrition = nutrition;
		this.p_id = p_id;
		this.photo = photo;
		this.photoPath = photoPath;
	}

	public Long getM_id() {
		return m_id;
	}
	public void setM_id(Long m_id) {
		this.m_id = m_id;
	}
	public String getMeal_name() {
		return meal_name;
	}
	public void setMeal_name(String meal_name) {
		this.meal_name = meal_name;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getNutrition() {
		return nutrition;
	}
	public void setNutrition(String nutrition) {
		this.nutrition = nutrition;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	@Override
	public String toString() {
		return "Meal [m_id=" + m_id + ", meal_name=" + meal_name + ", ingredients=" + ingredients + ", nutrition="
				+ nutrition + ", p_id=" + p_id + ", photo=" + photo + ", photoPath=" + photoPath + "]";
	}
	
	
}
