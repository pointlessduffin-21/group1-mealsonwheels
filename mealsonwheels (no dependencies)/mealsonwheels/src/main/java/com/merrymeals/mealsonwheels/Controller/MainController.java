package com.merrymeals.mealsonwheels.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.merrymeals.mealsonwheels.Entity.Meal;
import com.merrymeals.mealsonwheels.Service.MealService;

@Controller
public class MainController {
	
	@Autowired
	MealService mealService;

    @RequestMapping("/")
    public String landing() {
        return "Innnnndex";
    }

    @RequestMapping("/dashboard")
    public String homePage() {
        return "index";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/register")
    public String registerPage() {
        return "register";
    }

    @RequestMapping("/contact")
    public String contactUsPage() {
        return "contact";
    }

    @RequestMapping("/about")
    public String aboutUsPage() {
        return "about";
    }
  
    @RequestMapping("/member")
    public String memberDashboard(@RequestParam(required = false) String searchKey, Model model) {
        if (searchKey != null && !searchKey.equals("")) {
            searchKey = searchKey.split(" ")[0];

            List<Meal> mealResult = mealService.searchByKey(searchKey);
			model.addAttribute("mealResult", mealResult);
			
			if(mealResult.size() == 0) {
				model.addAttribute("noMealResult", true);
			}
        }

        return "member";
    }

    @RequestMapping("/volunteer")
    public String volunteerDashboard() {
        return "volunteer";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/donator")
    public String donatePage() {
        return "donator";
    }

    @RequestMapping("/kitchen")
    public String kitPage() {
        return "kitchen";
    }
}
