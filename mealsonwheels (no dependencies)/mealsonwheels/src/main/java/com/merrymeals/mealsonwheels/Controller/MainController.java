package com.merrymeals.mealsonwheels.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String landing() {
        return "index";
    }

    @RequestMapping("/dashboard")
    public String homePage() {
        return "home";
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
}
