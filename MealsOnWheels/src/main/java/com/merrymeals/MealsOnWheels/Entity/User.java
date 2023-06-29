package com.merrymeals.MealsOnWheels.Entity;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String email, String password, String name, String address, String contact, String health_issue) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.health_issue = health_issue;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", email=" + email + ", password=" + password + ", name=" + name + ", address="
				+ address + ", contact=" + contact + ", health_issue=" + health_issue + "]";
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof User))
			return false;
		User user = (User) o;
		return Objects.equals(this.u_id, user.u_id) && Objects.equals(this.email, user.email) && Objects.equals(this.password, user.password) && Objects.equals(this.name, user.name) && Objects.equals(this.address, user.address) && Objects.equals(this.contact, user.contact) && Objects.equals(this.health_issue, user.health_issue);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.u_id, this.email, this.password, this.name, this.address, this.contact, this.health_issue);
	}
}
