package com.merrymeals.mealsonwheels.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.merrymeals.mealsonwheels.Entity.Meal;
import com.merrymeals.mealsonwheels.Entity.Meal_Order;
import com.merrymeals.mealsonwheels.Entity.Role;
import com.merrymeals.mealsonwheels.Entity.User;
import com.merrymeals.mealsonwheels.Service.MealService;
import com.merrymeals.mealsonwheels.Service.OrderService;
import com.merrymeals.mealsonwheels.Service.UserService;
import com.merrymeals.mealsonwheels.Repository.UserRepository;
import com.merrymeals.mealsonwheels.Repository.RoleRepository;

import javax.servlet.http.HttpSession;


@Controller
public class MainController {

	@Autowired
	MealService mealService;

	@Autowired
	OrderService orderService;

	@Autowired
	UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

	// AUTH CONTROLLER

	@GetMapping("/login")
    public String onLogin() {
        return "login";
    }
	

	  @GetMapping("/login_error")
	    public String onLoginError(Model model) {
	        String error_msg = "That ain't right. Try Again.";
	        model.addAttribute("error_string", error_msg);
	        return "login";
	    }

//	    @GetMapping("/login_success")
//	    public String onLoginSuccess(HttpSession session, Model model) {
//	    	mealDetails.clear();
//
//	    	User loggedUser = (User) session.getAttribute("user");
//	        model.addAttribute("loggedUser", loggedUser);
//
//	    	String success_login = "Welcome to the world of ABC Used Cars.";
//	        model.addAttribute("success_login", success_login);
//
//	        model.addAttribute("selectedItems", selectedItems);
//
//	        List<Meal> mealResults = mealService.getAllMeals();
//	        model.addAttribute("mealResults", mealResults);
//
//	        List<Meal_Order> myOrders = orderService.getMealsByUId(loggedUser.getU_id());
//	        model.addAttribute("myOrders", myOrders);
//
//	        model.addAttribute("cartContent", mealDetails);
//
//	        String lastOrderNumber = orderService.getLastOrderNumber();
//	        int orderNumber = 0; // Default value when the order number is null
//
//			if (lastOrderNumber != null && !lastOrderNumber.isEmpty()) {
//			    orderNumber = Integer.parseInt(lastOrderNumber);
//			}
//
//	        int incrementedOrderNumber = orderNumber + 1;
//	        String incrementedOrderNumberString = String.valueOf(incrementedOrderNumber); // Convert back to a string
//
//	        model.addAttribute("orderNumber", incrementedOrderNumberString);
//
//	        return "member";
//	    }

    @GetMapping("login_success")
    public String onLogginSuccess () {
        return "member";
    }

        int incrementedOrderNumber = orderNumber + 1;
        String incrementedOrderNumberString = String.valueOf(incrementedOrderNumber); // Convert back to a string

        model.addAttribute("orderNumber", incrementedOrderNumberString);

        return "member";
    }


    @PostMapping("/login2")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        User user = userRepository.loginUser(email, password);
        if (user != null) {
            String roleName = userRepository.findRoleByUid(user.getU_id());
            Role role = roleRepository.findByName(roleName);
            if (role != null && role.getName().equals("ROLE_ADMIN")) {
                session.setAttribute("user", user);
                return "redirect:/admin";
            } else {
                return "redirect:/login?error=access_denied";
            }
        } else {
            return "redirect:/login?error=invalid_credentials";
        }
    }

	@PostMapping("/loginTa")
	public String login(@RequestParam String userName, @RequestParam String password, Model model, HttpSession session) {


        if (userService.loginUser(userName, password)) {

        	User user = userService.getUser(userName, password);
        	session.setAttribute("user", user);
        	
        	Long Uid = user.getU_id();
        	String roleName = userService.findRoleByUid(Uid);

        	if (roleName != "Member") {
        		session.setAttribute("role", "Member");
        		System.out.print("HUY LOG NAKA");

        	    return "redirect:/login_success";
        	} else {
        	    return "redirect:/login_error";
        	}
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "redirect:/login";
        }
    }




    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }

    // For Testing purposes (palihug ko remove ani once naa na sa main pages) - Roel
    @GetMapping("/distancematrixniroel")
    public String distance() {
        return "distancematrixniroel";
    }

    @GetMapping("/addfundsniroel")
    public String funds() {
        return "addfundsniroel";
    }

    @GetMapping("/tablefundsniroel")
    public String tablefunds() {
        return "tablefundsniroel";
    }

    // Diri rni kutob - Roel

    @GetMapping("/dashboard")
    public String homePage() {
        return "index";
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

    @GetMapping("/memberTwo")
    public String memberTwo(Model model) {

        List<Meal> mealResults = mealService.getAllMeals();
        model.addAttribute("mealResults", mealResults);

        return "search";
    }

    @GetMapping("/member")
    public String memberDashboard(Model model, HttpSession session) {
		/*
		 * User loggedUser = (User) session.getAttribute("user");
		 * model.addAttribute("loggedUser", loggedUser);
		 */

        List<Meal> mealResults = mealService.getAllMeals();
        model.addAttribute("mealResults", mealResults);

        mealDetails.clear();

        model.addAttribute("selectedItems", selectedItems);
        model.addAttribute("cartContent", mealDetails);

		/*
		 * List<Meal_Order> myOrders = orderService.getMealsByUId(loggedUser.getU_id());
		 * model.addAttribute("myOrders", myOrders);
		 */

        int orderNumber = 0; // Default value when the order number is null
        String lastOrderNumber = orderService.getLastOrderNumber();

        if (lastOrderNumber != null && !lastOrderNumber.isEmpty()) {
            orderNumber = Integer.parseInt(lastOrderNumber);
        }

        int incrementedOrderNumber = orderNumber + 1;
        String incrementedOrderNumberString = String.valueOf(incrementedOrderNumber); // Convert back to a string

        model.addAttribute("orderNumber", incrementedOrderNumberString);

        return "member";
    }


    @GetMapping(value="/search")
    public String search(@RequestParam String searchKey,HttpSession session, Model model) throws Exception {
    	User loggedUser = (User) session.getAttribute("user");
        model.addAttribute("loggedUser", loggedUser);

    	model.addAttribute("cartContent", mealDetails);

    	 List<Meal_Order> myOrders = orderService.getMealsByUId(loggedUser.getU_id());
	        model.addAttribute("myOrders", myOrders);

        if(searchKey != null && !searchKey.equals("")) {
            searchKey = searchKey.split(" ")[0];

            List<Meal> mealResults = mealService.search(searchKey);
            model.addAttribute("mealResults", mealResults);

            int orderNumber = Integer.parseInt(orderService.getLastOrderNumber());
            int incrementedOrderNumber = orderNumber + 1;
            String incrementedOrderNumberString = String.valueOf(incrementedOrderNumber); // Convert back to a string

            model.addAttribute("orderNumber", incrementedOrderNumberString);

            if(mealResults.size() == 0) {
                model.addAttribute("noMealResult", "No results found for this search. Try browsing meals");

                mealResults = mealService.getAllMeals();
                model.addAttribute("orderNumber", incrementedOrderNumberString);
                model.addAttribute("mealResults", mealResults);
                return "member";
            }
        }

        return "member";

    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/donator")
    public String donatePage() {
        return "donator";
    }

    @GetMapping("/kitchen")
    public String kitPage(Model model, HttpSession session) {
    	   List<Meal> mealResults = mealService.getAllMeals();
           model.addAttribute("mealResults", mealResults);

           mealDetails.clear();

           model.addAttribute("selectedItems", selectedItems);
           model.addAttribute("cartContent", mealDetails);
           
           
           List<Meal_Order> approvedMeals = orderService.getApproved();
           model.addAttribute("approvedMeals", approvedMeals);
           
           List<Meal_Order> acceptedMeals = orderService.getAccepted();
           model.addAttribute("acceptedMeals", acceptedMeals);
           
           List<User> volunteers = userService.listAllRider();
           model.addAttribute("riders", volunteers);
           
   		/*
   		 * List<Meal_Order> myOrders = orderService.getMealsByUId(loggedUser.getU_id());
   		 * model.addAttribute("myOrders", myOrders);
   		 */

           int orderNumber = 0; // Default value when the order number is null
           String lastOrderNumber = orderService.getLastOrderNumber();

           if (lastOrderNumber != null && !lastOrderNumber.isEmpty()) {
               orderNumber = Integer.parseInt(lastOrderNumber);
           }

           int incrementedOrderNumber = orderNumber + 1;
           String incrementedOrderNumberString = String.valueOf(incrementedOrderNumber); // Convert back to a string

           model.addAttribute("orderNumber", incrementedOrderNumberString);

        return "kitchen";
    }

    @GetMapping("/addmeal")
    public String addMeal() {
        return "addmeal";
    }
    
    @GetMapping("/volunteer")
    public String volunteer() {
        return "volunteer";
    }

//    DIMPLE NEW TOUCH UPS


    List<Long> selectedItems = new ArrayList<>();
    List<Meal> mealDetails = new ArrayList<>();

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("mealId") Long mealId,HttpSession session, Model model) {
		/*
		 * User loggedUser = (User) session.getAttribute("user");
		 * model.addAttribute("loggedUser", loggedUser);
		 * 
		 * List<Meal_Order> myOrders = orderService.getMealsByUId(loggedUser.getU_id());
		 * model.addAttribute("myOrders", myOrders);
		 */

        mealDetails.clear();

        List<Meal> mealResults = mealService.getAllMeals();
        model.addAttribute("mealResults", mealResults);

        selectedItems.add(mealId);

        for (Long itemId : selectedItems) {
            Meal meal = mealService.getCartOrders(itemId); // Retrieve meal details from service or repository
            if (meal != null) {
                mealDetails.add(meal);
            }
        }

        String lastOrderNumber = orderService.getLastOrderNumber();
        int orderNumber = 0; // Default value when the order number is null

        if (lastOrderNumber != null && !lastOrderNumber.isEmpty()) {
            orderNumber = Integer.parseInt(lastOrderNumber);
        }

        int incrementedOrderNumber = orderNumber + 1;
        String incrementedOrderNumberString = String.valueOf(incrementedOrderNumber); // Convert back to a string

        model.addAttribute("orderNumber", incrementedOrderNumberString);
        model.addAttribute("selectedItems", selectedItems);
        model.addAttribute("cartContent", mealDetails);

        return "member";
    }


    @PostMapping("/deleteFromCart")
    public String deleteFromCart(@RequestParam("mealId") Long mealId, Model model, HttpSession session) {

    	User loggedUser = (User) session.getAttribute("user");
        model.addAttribute("loggedUser", loggedUser);

        List<Meal_Order> myOrders = orderService.getMealsByUId(loggedUser.getU_id());
        model.addAttribute("myOrders", myOrders);

        List<Meal> mealResults = mealService.getAllMeals();
        model.addAttribute("mealResults", mealResults);

        boolean mealDeleted = false; // Flag to track if a meal is deleted

        Iterator<Meal> iterator = mealDetails.iterator();
        while (iterator.hasNext()) {
            Meal meal = iterator.next();
            if (meal.getM_id().equals(mealId)) {
                iterator.remove(); // Remove the item
                mealDeleted = true; // Set the flag to true
                selectedItems.remove(mealId);
                break; // Exit the loop once the item is removed
            }
        }

        if (!mealDeleted) {
            // Handle the case when the meal was not found in the cart
            model.addAttribute("errMsg", "Meal not found in the cart");
        }
        int orderNumber = Integer.parseInt(orderService.getLastOrderNumber());
        int incrementedOrderNumber = orderNumber + 1;
        String incrementedOrderNumberString = String.valueOf(incrementedOrderNumber); // Convert back to a string

        model.addAttribute("orderNumber", incrementedOrderNumberString);
        model.addAttribute("selectedItems", selectedItems);
        model.addAttribute("cartContent", mealDetails);
        return "member";
    }


    @PostMapping("/checkout")
    public String checkout(@RequestParam("mealId") String mealId, Model model, HttpSession session) throws Exception {
        try {
        	User loggedUser = (User) session.getAttribute("user");
	        model.addAttribute("loggedUser", loggedUser);
	        Long userId = loggedUser.getU_id();

	        List<Meal> mealResults = mealService.getAllMeals();
	        model.addAttribute("mealResults", mealResults);


	        List<Meal_Order> myOrders = orderService.getMealsByUId(loggedUser.getU_id());
	        model.addAttribute("myOrders", myOrders);

	        System.out.print("hi");
            String orderNumberString = orderService.getLastOrderNumber();
            int orderNumber = orderNumberString != null ? Integer.parseInt(orderNumberString) : 0;
            int incrementedOrderNumber = orderNumber + 1;
            String incrementedOrderNumberString = String.valueOf(incrementedOrderNumber);

            for (Long item : selectedItems) {
                Meal_Order order = new Meal_Order();
                order.setU_id(userId);
                order.setOrder_number(incrementedOrderNumberString);
                order.setOrder_date(java.time.LocalDate.now().toString());
                order.setM_id(item);
                order.setStatus("ORDERED");
                orderService.save(order);
            }

            model.addAttribute("orderNumber", incrementedOrderNumberString);
            model.addAttribute("successMsg", "Order placed successfully!");

            selectedItems.clear();
            return "member";
        } catch (Exception e) {
            System.out.println(e);
            model.addAttribute("errMsg", "Failed to order");
        }

        return "member";
    }

// Kitchen Stuff
    
    
    @PostMapping("/acceptOrder")
    public String acceptOrder(@RequestParam("orderId") Long orderId, HttpSession session, Model model) {
		
    	Meal_Order acceptedOrder = orderService.getOrder(orderId);
    	
    	acceptedOrder.setStatus("ACCEPTED");
    	
    	orderService.save(acceptedOrder);
        return "redirect:/kitchen";
    }


	  @GetMapping("/login_error")
	    public String onLoginError(Model model) {
	        String error_msg = "That ain't right. Try Again.";
	        model.addAttribute("error_string", error_msg);
	        return "login";
	    }
	  

	    @GetMapping("/logout")
	    public String onLogoutSuccess(Model model) {
	    	String success_logout = "See you next time";
	        model.addAttribute("success_logout", success_logout);

	    	return "login";
	    }

        @PostMapping("/assignRider")
        public String assignRiderr(@RequestParam("orderId") Long orderId,@RequestParam("riderId") Long riderId, HttpSession session, Model model) {

            Meal_Order riderAssigned = orderService.getOrder(orderId);


            riderAssigned.setStatus("COOKED");
            riderAssigned.setV_id(riderId);

            orderService.save(riderAssigned);
            return "redirect:/kitchen";
        }
	    
		@PostMapping("/register_user")
		public String registration(User user, @RequestParam("userRole") String role) {
			userService.saveUser(user,role);
			return "Regsitration Success" ;

		}
}
