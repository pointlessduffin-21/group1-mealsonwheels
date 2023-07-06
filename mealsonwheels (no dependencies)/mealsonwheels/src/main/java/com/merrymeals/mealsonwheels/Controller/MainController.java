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
    
    @RequestMapping("/admin")
    public String adminDashboard() {
        return "admin";
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
    
    @RequestMapping("/memberTwo")
    public String memberTwo(Model model) {
    	
    	List<Meal> mealResults = mealService.getAllMeals();
        model.addAttribute("mealResults", mealResults);
        
        return "search";
    }
    
    @RequestMapping("/member")
    public String memberDashboard(Model model) {
     
            List<Meal> mealResults = mealService.getAllMeals();
            model.addAttribute("mealResults", mealResults);
			
        return "member";
    }
    
    @RequestMapping(value="/search")
	public String search(@RequestParam String searchKey, Model model) throws Exception {
        
		if(searchKey != null && !searchKey.equals("")) {
			searchKey = searchKey.split(" ")[0];
			
			List<Meal> mealResults = mealService.search(searchKey);
			model.addAttribute("mealResults", mealResults);
			
			if(mealResults.size() == 0) {
				model.addAttribute("noMealResult", "No results found for this search. Try browsing meals");
				
				mealResults = mealService.getAllMeals();
				model.addAttribute("mealResults", mealResults);
				return "member";
			}
	    }
		
		return "member";
		
	}

    @RequestMapping("/volunteer")
    public String volunteerDashboard() {
        return "volunteer";
    }
}
