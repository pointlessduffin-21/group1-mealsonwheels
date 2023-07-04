package com.merrymeals.mealsonwheels.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.merrymeals.mealsonwheels.Entity.User;
import com.merrymeals.mealsonwheels.Service.UserService;

@Controller
public class AuthController {

	@Autowired
	public UserService us;
	
	 @PostMapping("/register_user")
	    public User registration(@RequestBody User user, @RequestParam("userRole") String role) {
	    	
		 us.saveUser(user,role);	
	    	return user ;
	    	
	    }
	 
	 
}
