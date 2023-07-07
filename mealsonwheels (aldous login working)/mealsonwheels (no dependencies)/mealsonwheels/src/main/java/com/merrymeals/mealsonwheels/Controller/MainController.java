package com.merrymeals.mealsonwheels.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.merrymeals.mealsonwheels.Entity.Meal;
import com.merrymeals.mealsonwheels.Entity.User;
import com.merrymeals.mealsonwheels.Service.MealService;
import com.merrymeals.mealsonwheels.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	MealService mealService;
	
	@Autowired 
	UserService userService;

    @RequestMapping("/")
    public String landing() {
        return "index";
    }

    // For Testing purposes (palihug ko remove ani once naa na sa main pages) - Roel
    @RequestMapping("/distancematrixniroel")
    public String distance() {
        return "distancematrixniroel";
    }

    @RequestMapping("/addfundsniroel")
    public String funds() {
        return "addfundsniroel";
    }

    @RequestMapping("/tablefundsniroel")
    public String tablefunds() {
        return "tablefundsniroel";
    }

    // Diri rni kutob - Roel

    @RequestMapping("/dashboard")
    public String homePage() {
        return "index";
    }
    
    @GetMapping("/loginPage")
    public String loginPage() {
        return "login";
    }
    
    // DIMPLE TOUCHED THIS
    
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
        if (userService.loginUser(email, password)) {
        	User user = userService.getUser(email, password);
        	session.setAttribute("user", user);
            return "redirect:/member";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
    
    // ENDS HERE

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
    
    // DIMPLE TOUCHED THIS
    
    @RequestMapping("/member")
    public String memberDashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
        	
        	List<Meal> mealResults = mealService.getAllMeals();
            model.addAttribute("mealResults", mealResults);
            model.addAttribute("loggedUser", user);
            return "member";
            
        } else {
            return "redirect:/loginPage";
        }
    }
    
    // ENDS HERE

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
