package com.merrymeals.mealsonwheels.Service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merrymeals.mealsonwheels.Entity.Partner;
import com.merrymeals.mealsonwheels.Entity.User;
import com.merrymeals.mealsonwheels.Repository.UserRepository;
import com.merrymeals.mealsonwheels.Repository.PartnerRepository;
import com.merrymeals.mealsonwheels.Repository.RoleRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	public UserRepository ur;

	@Autowired
	public RoleRepository rs;

	@Autowired
	public PartnerRepository pr;


	//	User
	public void saveUser(User u, String r) {

		u.setRoles(new HashSet<>(rs.findBySpecificRoles(r)));
		ur.save(u);
	}

	public User getUser(Long id) {
		return ur.findById(id).get();
	}

	public void deleteUser(Long id) {
		ur.deleteById(id);
	}

//	public Boolean loginUser(String email, String password) {
//		User logUser = ur.login(email, password);
//		if (logUser != null) {
//			return true;
//		}
//
//		return false;
//
//	}

	public Boolean loginUser(String email, String password) {
		User logUser = ur.loginUser(email, password);
		if (logUser != null) {
			return true;
		}

		return false;
	}


// Partner

	public void savePartner(Partner p) {

		p.setRoles(new HashSet<>(rs.findBySpecificRoles("Partner")));
		pr.save(p);
	}

	public Partner getPartner(Long id) {
		return pr.findById(id).get();
	}

	public void deletePartner(Long id) {
		pr.deleteById(id);
	}

	public Boolean loginPartner(String email, String password) {
		Partner partUser = pr.loginPartner(email, password);
		if (partUser != null) {
			return true;
		}

		return false;

	}

}