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
import jakarta.persistence.OneToOne;

import com.merrymeals.mealsonwheels.Entity.Role;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long u_id;
	private String email;
	private String password;
	private String name;
	private String userName;
	private String address;
	private String contact;
	private String age;

	@ManyToMany
	@JoinTable( name="user_role",
			joinColumns = @JoinColumn(name = "u_id"),
			inverseJoinColumns = @JoinColumn(name = "r_id"))
	private Set<Role> roles = new HashSet<>();


	public User() {

	}

	public User(Long u_id, String email, String password, String name, String userName, String address, String contact,
				String age, Set<Role> roles, Set<Health_Issue> issues, Set<Partner> partner) {
		super();
		this.u_id = u_id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.userName = userName;
		this.address = address;
		this.contact = contact;
		this.age = age;
		this.roles = roles;
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


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", email=" + email + ", password=" + password + ", name=" + name + ", userName="
				+ userName + ", address=" + address + ", contact=" + contact + ", age=" + age + ", roles=" + roles
				+ "]";
	}













}