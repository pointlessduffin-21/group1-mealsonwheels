<%@ page import="com.merrymeals.mealsonwheels.Entity.Meal_Order" %>
<%@ page import="com.merrymeals.mealsonwheels.Entity.Meal" %>
<%@ page import="com.merrymeals.mealsonwheels.Entity.User" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html data-bs-theme="light" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/bootstrap/css/style.css">
    <title>Kitchen Dashboard</title>
    <link href="https://cdn-icons-png.flaticon.com/512/7541/7541900.png" rel="icon">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>

	<%@ include file="header.jsp"%>

    <!-- Main Dashboard -->
    <div class="dashboard">
        <div class="dashboard-banner">
            <img src="https://i.pinimg.com/564x/25/e6/a1/25e6a1365e9a35071db3c7d2d8ea6eab.jpg">
            <div class="banner-promo">
                <h1><span>50% OFF</span><br>
                Tasty Food<br> On Your Hand
                </h1>
            </div>
        </div>

        <h3 class="dashboard-title">Recommended Food For You</h3>
        <div class="dashboard-menu">
            <a href="#">Favorites</a>
            <a href="#">Best Seller</a>
            <a href="#">Near Me</a>
            <a href="#">Promotion</a>
            <a href="#">Top Rated</a>
            <a href="#">All</a>
        </div>

        <div class="dashboard-content">
        
         <% String noMealResult = (String) request.getAttribute("noMealResult"); %>
	    <% if (noMealResult != null) { %>
	    <div class="border rounded text-center py-3 mx-5">
	        <h6 class="fw-bold mb-0"><%= noMealResult %></h6>
	    </div>
	    <% } %>
        
        <div class=" mx-5">

        <% List<Meal> mealResult = (List<Meal>) request.getAttribute("mealResults"); %>
        <div style="margin: 16px;">
            <% if (mealResult != null && !mealResult.isEmpty()) { %>
            <% int count = 0; %>
            <% for (Meal meal : mealResult) { %>
            <% if (count % 4 == 0) { %>
            <div class="row mb-3">
                <% } %>
                <div class="col-sm-3 pe-1">
                    <div class="dashboard-card">
                        <img class="card-image" src="<%= meal.getPhotoPath() %>">
                        <div class="card-detail">
                            <h4><%= meal.getMeal_name() %>
                            	<span>  
      


								</span>
								<p>Meal no.  <%= meal.getM_id() %></p>
								<p><%= meal.getDescription() %></p>
                            	<p class="card-time"><span class="fas fa-clock"></span> <%= meal.getDuration() %></p>
							</h4>
							
                            <%-- <p>Nutrition: <%= meal.getNutrition() %></p>
                            <p class="card-time"><span class="fas fa-carrot"></span><%= meal.getIngredients() %></p> --%>
                        </div>
                    </div>
                </div>
                <% if (count % 4 == 3 || count == mealResult.size() - 1) { %>
            </div>
            <% } %>
            <% count++; %>
            <% } %>
            <% } %>
        </div>

    </div>
        
          <!--   <div class="dashboard-card">
                <img class="card-image" src="https://hips.hearstapps.com/hmg-prod/images/classic-cheese-pizza-recipe-2-64429a0cb408b.jpg?crop=0.6666666666666667xw:1xh;center,top&resize=1200:*">
                <div class="card-detail">
                    <h4>Amazing Pizza<span><label for="cart" class="label-cart"><span class="fas fa-shopping-cart"></span></label></span></h4>
                    <p>Lorem ipsum dolor sit.</p>
                </div>
            </div>
            <div class="dashboard-card">
                <img class="card-image" src="https://images.immediate.co.uk/production/volatile/sites/30/2014/05/Epic-summer-salad-hub-2646e6e.jpg">
                <div class="card-detail">
                    <h4>Fresh Salad<span><label for="cart" class="label-cart"><span class="fas fa-shopping-cart"></span></label></span></h4>
                    <p>Lorem ipsum dolor sit.</p>
                </div>
            </div>
            <div class="dashboard-card">
                <img class="card-image" src="https://static.onecms.io/wp-content/uploads/sites/43/2022/02/16/21014-Good-old-Fashioned-Pancakes-mfs_001.jpg">
                <div class="card-detail">
                    <h4>Sweet Pancake<span><label for="cart" class="label-cart"><span class="fas fa-shopping-cart"></span></label></span></h4>
                    <p>Lorem ipsum dolor sit.</p>
                </div>
            </div>
            <div class="dashboard-card">
                <img class="card-image" src="https://www.seriouseats.com/thmb/WzQz05gt5witRGeOYKTcTqfe1gs=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/butter-basted-pan-seared-steaks-recipe-hero-06-03b1131c58524be2bd6c9851a2fbdbc3.jpg">
                <div class="card-detail">
                    <h4>Steak<span><label for="cart" class="label-cart"><span class="fas fa-shopping-cart"></span></label></span></h4>
                    <p>Lorem ipsum dolor sit.</p>
                </div>
            </div>
            <div class="dashboard-card">
                <img class="card-image" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLY5j-0GxBdLWv53oNAH6KKQszBRTDWstPXg&usqp=CAU">
                <div class="card-detail">
                    <h4>Healthy Breakfast<span><label for="cart" class="label-cart"><span class="fas fa-shopping-cart"></span></label></span></h4>
                    <p>Lorem ipsum dolor sit.</p>
                </div>
            </div>
            <div class="dashboard-card">
                <img class="card-image" src="https://assets.epicurious.com/photos/5c745a108918ee7ab68daf79/1:1/w_2560%2Cc_limit/Smashburger-recipe-120219.jpg">
                <div class="card-detail">
                    <h4>Fantastic Burger<span><label for="cart" class="label-cart"><span class="fas fa-shopping-cart"></span></label></span></h4>
                    <p>Lorem ipsum dolor sit.</p>
                </div>
            </div>
        </div>
        <div class="text-center p-5">
        	<button class="btn btn-success p-4" type="button" data-bs-toggle="modal" data-bs-target="#addMenuModal">Add Menu</button>
        </div> -->
    </div>

    <!-- Order Dashboard -->
    <div class="dashboard-order" style="padding-top:90px;">
		<div class="card-header py-3">
			<h6 class="text-secondary fw-bold m-0"
				style="color: rgb(45, 237, 42);">Incoming</h6>
		</div>
        <div class="order-wrapper">
        <% List<Meal_Order> approvedMeals = (List<Meal_Order>) request.getAttribute("approvedMeals"); %>
       		<% if (approvedMeals != null && !approvedMeals.isEmpty()) { %>
       		<% for (Meal_Order order : approvedMeals) { %>
        <div class="order-card">
                <% mealResult = (List<Meal>) request.getAttribute("mealResults"); %>
		       	<% for (Meal approvedMeal : mealResult) { %>
		       	<% if (order.getM_id() == approvedMeal.getM_id()) { %>
                <img class="order-image" src="<%= approvedMeal.getPhotoPath() %>">
                <div class="order-detail">
                    <p><%= approvedMeal.getMeal_name() %></p>
                    <p><%= order.getU_id() %></p>
                    <p><%= order.getP_id() %></p>
					<div style="display: flex;">
					  <span style="margin-right: 10px;">
					    <button class="btn btn-success" type="button" style="width: 80px; padding: 6px 12px;">Accept</button>
					  </span>
					</div>
                </div>
	            <% } %>
				<% } %>
            </div>
            <% } %>
			<% } %>
       
        
           <!--  <div class="order-card">
                <img class="order-image" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLY5j-0GxBdLWv53oNAH6KKQszBRTDWstPXg&usqp=CAU">
                <div class="order-detail">
                    <p>Fried Chicken | ON: #121</p>
					<div style="display: flex;">
					  <span style="margin-right: 10px;">
					    <button class="btn btn-success" type="button" style="width: 80px; padding: 6px 12px;">Accept</button>
					  </span>
					  <span>
					    <button class="btn btn-danger" type="button" style="width: 80px; padding: 6px 12px;" data-bs-toggle="modal" data-bs-target="#declineModal1">Decline</button>
					  </span>
					</div>
                </div>
            </div>
            <div class="order-card">
                <img class="order-image" src="https://images.immediate.co.uk/production/volatile/sites/30/2014/05/Epic-summer-salad-hub-2646e6e.jpg">
                <div class="order-detail">
                    <p>Chicken Adobo | ON: #122</p>
                    <div style="display: flex;">
					  <span style="margin-right: 10px;">
					    <button class="btn btn-success" type="button" style="width: 80px; padding: 6px 12px;">Accept</button>
					  </span>
					  <span>
					    <button class="btn btn-danger" type="button" style="width: 80px; padding: 6px 12px;" data-bs-toggle="modal" data-bs-target="#declineModal1">Decline</button>
					  </span>
					</div>
                </div>
            </div>
            <div class="order-card">
                <img class="order-image" src="https://assets.epicurious.com/photos/5c745a108918ee7ab68daf79/1:1/w_2560%2Cc_limit/Smashburger-recipe-120219.jpg">
                <div class="order-detail">
                    <p>Pork Menudo | ON: #123</p>
                    <div style="display: flex;">
					  <span style="margin-right: 10px;">
					    <button class="btn btn-success" type="button" style="width: 80px; padding: 6px 12px;">Accept</button>
					  </span>
					  <span>
					    <button class="btn btn-danger" type="button" style="width: 80px; padding: 6px 12px;" data-bs-toggle="modal" data-bs-target="#declineModal1">Decline</button>
					  </span>
					</div>
                </div>
            </div> -->
        </div><br><br><br>
        <hr class="divider">
        
        
        
		<div class="card-header py-3">
			<h6 class="text-secondary fw-bold m-0"
				style="color: rgb(45, 237, 42);">Delivery</h6>
		</div>
		<div class="order-wrapper">
            <div class="order-card">
                <div class="order-detail">
                    <p>Order Number: #121</p>
                    <select class="form-select rider-dropdown">
			          <option selected disabled>Select a rider</option>
			          <option>Rider 1</option>
			          <option>Rider 2</option>
			          <option>Rider 3</option>
			        </select>
					<div style="display: flex;" class="pt-2">
					  <span style="margin-right: 10px;">
					    <button class="btn text-white" type="button" style="width: 220px; padding: 6px 12px; background: rgb(86, 114, 216);">Deliver</button>
					  </span>
					</div>
                </div>
            </div>
            <hr class="divider">
            <div class="order-card">
                <div class="order-detail">
                    <p>Order Number: #122</p>
                    <select class="form-select rider-dropdown">
			          <option selected disabled>Select a rider</option>
			          <option>Rider 1</option>
			          <option>Rider 2</option>
			          <option>Rider 3</option>
			        </select>
					<div style="display: flex;" class="pt-2">
					  <span style="margin-right: 10px;">
					    <button class="btn text-white" type="button" style="width: 220px; padding: 6px 12px; background: rgb(86, 114, 216);">Deliver</button>
					  </span>
					</div>
                </div>
            </div>
            <hr class="divider">
            <div class="order-card">
                <div class="order-detail">
                    <p>Order Number: #123</p>
                    <select class="form-select rider-dropdown">
			          <option selected disabled>Select a rider</option>
			          <option>Rider 1</option>
			          <option>Rider 2</option>
			          <option>Rider 3</option>
			        </select>
					<div style="display: flex;" class="pt-2">
					  <span style="margin-right: 10px;">
					    <button class="btn text-white" type="button" style="width: 220px; padding: 6px 12px; background: rgb(86, 114, 216);">Deliver</button>
					  </span>
					</div>
                </div>
            </div>

        </div>
    </div>

<div class="modal fade" id="addMenuModal" tabindex="-1" role="dialog" aria-labelledby="addMenuModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="addMenuModalLabel">Add Menu</h5>
        <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group pb-3">
            <label for="menuName">Menu Name</label>
            <input type="text" class="form-control" id="menuName" placeholder="Enter the menu name">
          </div>
          <div class="form-group pb-3">
            <label for="menuIngredients">Menu Description</label>
            <textarea class="form-control" id="menuIngredients" rows="3" placeholder="Enter the menu ingredients"></textarea>
          </div>
          <div class="form-group">
            <label for="menuPicture">Menu Picture</label><br>
            <input type="file" class="form-control-file" id="menuPicture">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-success">Save</button>
      </div>
    </div>
  </div>
</div>


<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="https://cdn.reflowhq.com/v2/toolkit.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="assets/js/theme.js"></script>

</body>
</html>