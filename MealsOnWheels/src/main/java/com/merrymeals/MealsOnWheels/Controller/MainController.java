package com.merrymeals.MealsOnWheels.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
 
	@GetMapping("/")
	public String landing() {
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@GetMapping("/contact")
	public String contactUsPage() {
		return "contact";
	}
	
	@GetMapping("/about")
	public String aboutUsPage() {
		return "about";
	}
}
