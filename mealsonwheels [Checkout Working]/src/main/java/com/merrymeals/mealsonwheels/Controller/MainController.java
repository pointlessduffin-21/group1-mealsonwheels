package com.merrymeals.mealsonwheels.Controller;

import java.util.ArrayList;
import java.util.Iterator;
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
import com.merrymeals.mealsonwheels.Entity.Meal_Order;
import com.merrymeals.mealsonwheels.Service.MealService;
import com.merrymeals.mealsonwheels.Service.OrderService;

import javax.servlet.http.HttpSession;


@Controller
public class MainController {
	
	@Autowired
	MealService mealService;

	@Autowired
	OrderService orderService;

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

    @RequestMapping("/loginPage")
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

    @RequestMapping("/memberTwo")
    public String memberTwo(Model model) {

        List<Meal> mealResults = mealService.getAllMeals();
        model.addAttribute("mealResults", mealResults);

        return "search";
    }

    @RequestMapping("/member")
    public String memberDashboard(Model model) {
        model.addAttribute("selectedItems", selectedItems);

        List<Meal> mealResults = mealService.getAllMeals();
        model.addAttribute("mealResults", mealResults);

        model.addAttribute("cartContent", mealDetails);
        
        String lastOrderNumber = orderService.getLastOrderNumber();
        int orderNumber = 0; // Default value when the order number is null

		if (lastOrderNumber != null && !lastOrderNumber.isEmpty()) {
		    orderNumber = Integer.parseInt(lastOrderNumber);
		}
        
        int incrementedOrderNumber = orderNumber + 1;
        String incrementedOrderNumberString = String.valueOf(incrementedOrderNumber); // Convert back to a string

        model.addAttribute("orderNumber", incrementedOrderNumberString);

        return "member";
    }


    @RequestMapping(value="/search")
    public String search(@RequestParam String searchKey, Model model) throws Exception {
    	model.addAttribute("cartContent", mealDetails);

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
    
    @RequestMapping("/addmeal")
    public String addMeal() {
        return "addmeal";
    }
    
    
    
//    DIMPLE NEW TOUCH UPS
    

    List<Long> selectedItems = new ArrayList<>();
    List<Meal> mealDetails = new ArrayList<>();
    
    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("mealId") Long mealId, Model model) {
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
    public String deleteFromCart(@RequestParam("mealId") Long mealId, Model model) {

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

    
    @RequestMapping("/checkout")
    public String checkout(@RequestParam("mealId") String mealId, Model model) throws Exception {
        try {
            String orderNumberString = orderService.getLastOrderNumber();
            int orderNumber = orderNumberString != null ? Integer.parseInt(orderNumberString) : 0;
            int incrementedOrderNumber = orderNumber + 1;
            String incrementedOrderNumberString = String.valueOf(incrementedOrderNumber);

            for (Long item : selectedItems) {
                Meal_Order order = new Meal_Order();
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




    
    

    
}
