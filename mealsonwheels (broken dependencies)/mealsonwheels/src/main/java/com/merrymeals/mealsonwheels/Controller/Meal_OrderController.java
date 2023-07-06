package com.merrymeals.mealsonwheels.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.merrymeals.mealsonwheels.Entity.User;
import com.merrymeals.mealsonwheels.Entity.Meal_Order;
import com.merrymeals.mealsonwheels.Service.MealService;
import com.merrymeals.mealsonwheels.Service.UserService;

@Controller
public class Meal_OrderController {

	@Autowired
	MealService ms;
	
	@Autowired
	UserService us;
	
//	Ang meal_id kay makuha sa front end, dapat inig ka himo sa form na mu order ani kay makuha ang id sa meal na gi order
	@PostMapping("member_order")
	public String setMemberMeal(Principal principal,@RequestParam Long meal_id) {
//		This should get who is currently logged, not really sure, based ni sa ABCUsedCarPortal na project
		String username = principal.getName();
//		This should get the user na logged in, in this case member
		User member = us.findLoginUser(username);
//		Gikiuha ani ang id sa member
		Long mem_id = member.getU_id();
		
		Meal_Order order = new Meal_Order();
		
		order.setMem_id(mem_id);
		order.setMeal_id(meal_id);
		
		ms.saveOrder(order);
		
		return "member";
	}
	
//	Mukuha ni siya sa meal_order id
	@PostMapping("volunteer_choose")
	public String setVolunteer(Principal principal,@RequestParam Long mo_id ) {
		
		String username = principal.getName();
		
		User volunteer = us.findLoginUser(username);
		
		Long vol_id = volunteer.getU_id();
		
		Meal_Order order = ms.getOrder(mo_id);
		
		order.setVol_id(vol_id);
		
		ms.saveOrder(order);
		
		return "volunteer";
	}
	
	@PostMapping("partner_pick")
	public String setPartner (Principal principal,@RequestParam Long mo_id ) {
		
		String username = principal.getName();
		
		User partner = us.findLoginUser(username);
		
		Long part_id = partner.getU_id();
		
		Meal_Order order = ms.getOrder(mo_id);
		
		order.setPart_id(part_id);
		
		ms.saveOrder(order);
		
		return "kitchen";
	}
}
