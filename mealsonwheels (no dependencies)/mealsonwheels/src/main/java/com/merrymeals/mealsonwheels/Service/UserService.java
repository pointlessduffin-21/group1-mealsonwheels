package com.merrymeals.mealsonwheels.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merrymeals.mealsonwheels.Entity.User;
import com.merrymeals.mealsonwheels.Repsoitory.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	UserRepository ur;
	
	public void save(User u) {
		ur.save(u);
	}
	
	public User get(Long id) {
		return ur.findById(id).get();
	}
	
	public void delete(Long id) {
		ur.deleteById(id);
	}

}
