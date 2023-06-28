package com.merrymeals.MealsOnWheels.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.merrymeals.MealsOnWheels.Entity.Role;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long u_id;
	private String email;
	private String password;
	private String name;
	private String address;
	private String contact;
	
	@ManyToMany
	@JoinTable( name="user_role",
	            joinColumns = @JoinColumn(name = "u_id"),
	            inverseJoinColumns = @JoinColumn(name = "r_id"))
	private Set<Role> roles = new HashSet<>();
	
	private String health_issue;
	
	public User() {
		
	}
	
	public User(Long u_id, String email, String password, String name, String address, String contact, String health_issue) {
		this.u_id = u_id;
		this.email = email;
		this.password = 
		this.name = name;
		this.address = address;
		this.contact = contact;
		
		this.health_issue = health_issue;
	}
	
	public Long getU_id() {
		return u_id;
	}
	public void setU_id(Long u_id) {
		this.u_id = u_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getHealth_issue() {
		return health_issue;
	}
	public void setHealth_issue(String health_issue) {
		this.health_issue = health_issue;
	}
	
}
