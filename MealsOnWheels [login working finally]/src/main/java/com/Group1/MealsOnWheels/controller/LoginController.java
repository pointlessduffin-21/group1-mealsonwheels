package com.Group1.MealsOnWheels.controller;

import com.Group1.MealsOnWheels.Entity.User;
import com.Group1.MealsOnWheels.repository.UserRepository;
import com.Group1.MealsOnWheels.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("login")
    public String onLogin() {
        return "login";
    }


    @GetMapping("login_error")
    public String onLoginError(Model model) {
        String error_msg = "Incorrect username or password. Try Again.";
        model.addAttribute("error_string", error_msg);
        System.out.println(error_msg);
        return "login";
    }

    @GetMapping("register_user")
    public String showRegistrationForm(@ModelAttribute("user") User user) {


        return "Register";
    }

    @PostMapping("register")
    public String registerNewUser(@ModelAttribute("user") User user, Model model) {

        userService.save(user);

        String success_register = "Registeration Successful! ";
        model.addAttribute("success_register", success_register);

        return "Register";
    }

    @GetMapping("login_success")
    public String logginSuccess(HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            UserDetails loggedUser = (UserDetails) authentication.getPrincipal();
            session.setAttribute("user", loggedUser);
            System.out.println("User has logged in as: " + loggedUser.getUsername());
        }

        return "index";
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "testy";
    }

//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request) {
//        request.getSession().invalidate();
//        System.out.println("User has logged out.");
//    	return "login";
//    }

}
