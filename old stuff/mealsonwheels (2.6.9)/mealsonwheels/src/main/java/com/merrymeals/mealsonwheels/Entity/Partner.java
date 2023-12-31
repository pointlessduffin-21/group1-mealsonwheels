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

@Entity
public class Partner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long p_id;
	private String email;
	private String password;
	private String name;
	private String address;
	private String contact;

	@ManyToMany
	@JoinTable( name="partner_role",
			joinColumns = @JoinColumn(name = "p_id"),
			inverseJoinColumns = @JoinColumn(name = "r_id"))
	private Set<Role> roles = new HashSet<>();
  
	public Partner() {

	}


	public Partner(Long p_id, String email, String password, String name, String userName, String address,
				   String contact, Set<Role> roles) {
		super();
		this.p_id = p_id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.roles = roles;
	}

	public Long getP_id() {
		return p_id;
	}

	public void setP_id(Long p_id) {
		this.p_id = p_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "Partner [p_id=" + p_id + ", email=" + email + ", password=" + password + ", name=" + name
				+  ", address=" + address + ", contact=" + contact + ", roles=" + roles + "]";
	}
}
