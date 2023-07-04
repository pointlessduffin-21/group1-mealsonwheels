package com.merrymeals.mealsonwheels.Entity;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import com.merrymeals.mealsonwheels.Entity.Role;

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
	
	@OneToMany(mappedBy = "user")
	private Set<Health_Issue> issue = new HashSet<>();
	
	@OneToMany(mappedBy = "volunteer")
	private Set<Partner> partner = new HashSet<>();
	
	
	
	public User() {
		
	}
	
	
	
	public User(Long u_id, String email, String password, String name, String address, String contact, Set<Role> roles,
			Set<Health_Issue> issue, Set<Partner> partner) {
		super();
		this.u_id = u_id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.roles = roles;
		this.issue = issue;
		this.partner = partner;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles(){
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Health_Issue> getIssue() {
		return issue;
	}


	public void setIssue(Set<Health_Issue> issue) {
		this.issue = issue;
	}

	public Set<Partner> getPartner() {
		return partner;
	}

	public void setPartner(Set<Partner> partner) {
		this.partner = partner;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", email=" + email + ", password=" + password + ", name=" + name + ", address="
				+ address + ", contact=" + contact + ", roles=" + roles + ", issue=" + issue + ", partner=" + partner
				+ "]";
	}

	

	
}
