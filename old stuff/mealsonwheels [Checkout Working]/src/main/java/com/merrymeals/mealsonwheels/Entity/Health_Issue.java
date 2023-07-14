package com.merrymeals.mealsonwheels.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Health_Issue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long hi_id;
	private String issueDetails;
	private String allergies;

	public Health_Issue() {

	}

	public Health_Issue(Long hi_id, String issueDetails, String allergies, User user) {
		super();
		this.hi_id = hi_id;
		this.issueDetails = issueDetails;
		this.allergies = allergies;
	}



	public Long getHi_id() {
		return hi_id;
	}

	public void setHi_id(Long hi_id) {
		this.hi_id = hi_id;
	}

	public String getIssueDetails() {
		return issueDetails;
	}

	public void setIssueDetails(String issueDetails) {
		this.issueDetails = issueDetails;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}


	@Override
	public String toString() {
		return "Health_Issue [hi_id=" + hi_id + ", issueDetails=" + issueDetails + ", allergies=" + allergies
				+ "]";
	}



}