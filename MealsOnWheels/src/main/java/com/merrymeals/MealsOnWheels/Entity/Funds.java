package com.merrymeals.MealsOnWheels.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funds {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long f_id;
	private double donation;
	private Long u_id;
	private String date;
	//There was a thing for dates, I dunno how yet
	
	public Funds() {
		
	}
	
	public Funds(Long f_id, double donation, Long u_id, String date) {
		super();
		this.f_id = f_id;
		this.donation = donation;
		this.u_id = u_id;
		this.date = date;
	}

	public Long getF_id() {
		return f_id;
	}
	public void setF_id(Long f_id) {
		this.f_id = f_id;
	}
	public double getDonation() {
		return donation;
	}
	public void setDonation(double donation) {
		this.donation = donation;
	}
	public Long getU_id() {
		return u_id;
	}
	public void setU_id(Long u_id) {
		this.u_id = u_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
