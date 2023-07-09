package com.merrymeals.mealsonwheels.Service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merrymeals.mealsonwheels.Entity.Partner;
import com.merrymeals.mealsonwheels.Entity.User;
import com.merrymeals.mealsonwheels.Repository.UserRepository;
import com.merrymeals.mealsonwheels.Repository.PartnerRepository;
import com.merrymeals.mealsonwheels.Repository.RoleRepository;
import com.merrymeals.mealsonwheels.Security.UserDetailsServiceImpl;

@Service
@Transactional
public class UserService {

	@Autowired
	public UserRepository ur;

	@Autowired
	public RoleRepository rs;

	@Autowired
	public PartnerRepository pr;

	@Autowired
	public UserDetailsServiceImpl userDetailsService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private final AuthenticationManager authenticationManager;

	public UserService(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}


	//	User
	public void saveUser(User u, String r) {

		u.setRoles(new HashSet<>(rs.findBySpecificRoles(r)));
		u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		ur.save(u);
	}

	public User getUser(Long id) {
		return ur.findById(id).get();
	}

	public void deleteUser(Long id) {
		ur.deleteById(id);
	}

	public boolean loginUser(String email, String password) {
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
			Authentication authentication = authenticationManager.authenticate(authenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return true;
		} catch (AuthenticationException e) {
			return false;
		}
	}

// Partner

	public void savePartner(Partner p) {

		p.setRoles(new HashSet<>(rs.findBySpecificRoles("Partner")));
		p.setPassword(bCryptPasswordEncoder.encode(p.getPassword()));
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