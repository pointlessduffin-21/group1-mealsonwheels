import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.merrymeals.mealsonwheels.Entity.Meal_Order;
import com.merrymeals.mealsonwheels.Entity.User;
import com.merrymeals.mealsonwheels.Service.MealService;
import com.merrymeals.mealsonwheels.Service.OrderService;
import com.merrymeals.mealsonwheels.Service.UserService;

@RestController
public class TestController {

	@Autowired
	MealService mealService;

	@Autowired
	OrderService orderService;

	@Autowired
	UserService userService;
	
	
}
