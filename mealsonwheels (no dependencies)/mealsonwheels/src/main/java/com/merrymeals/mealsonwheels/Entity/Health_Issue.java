package com.merrymeals.mealsonwheels.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;

@Entity
public class Health_Issue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long hi_id;
	private String issueDetails;
	private String allergies;
	
	@OneToOne
	@JoinTable( name="user_issue",
	            joinColumns = @JoinColumn(name = "hi_id"),
	            inverseJoinColumns = @JoinColumn(name = "u_id"))
	private Set<User> user = new HashSet<>();

	public Health_Issue() {
		
	}
	
	
	
	public Health_Issue(Long hi_id, String issueDetails, String allergies, Set<User> user) {
		super();
		this.hi_id = hi_id;
		this.issueDetails = issueDetails;
		this.allergies = allergies;
		this.user = user;
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

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Health_Issue [hi_id=" + hi_id + ", issueDetails=" + issueDetails + ", allergies=" + allergies
				+ ", user=" + user + "]";
	}
	
	
	
}
