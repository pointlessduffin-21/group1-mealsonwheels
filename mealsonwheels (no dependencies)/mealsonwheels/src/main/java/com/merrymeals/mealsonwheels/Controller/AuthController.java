package com.merrymeals.mealsonwheels.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.merrymeals.mealsonwheels.Service.UserService;

@Controller
public class AuthController {

	@Autowired
	private UserService ur;
}
