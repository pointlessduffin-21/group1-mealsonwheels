<%--   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@ page import="com.merrymeals.mealsonwheels.Entity.Meal" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/bootstrap/css/style.css">
    <title>Member Dashboard</title>
    <link href="https://cdn-icons-png.flaticon.com/512/7541/7541900.png" rel="icon">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    
    <!-- JSTL -->
    <%-- <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  --%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jstl/1.2/jstl.min.js"></script>
    
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
    
</head>
<body>

	<%@ include file="header.jsp"%>

    <!-- header -->
        <input type="checkbox" id="cart">
    	<label for="cart" class="label-cart"><span class="fas fa-shopping-cart"></span></label>

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
            <div class="dashboard-card">
                <img class="card-image" src="https://hips.hearstapps.com/hmg-prod/images/classic-cheese-pizza-recipe-2-64429a0cb408b.jpg?crop=0.6666666666666667xw:1xh;center,top&resize=1200:*">
                <div class="card-detail">
                    <h4>Amazing Pizza<span>$30</span></h4>
                    <p>Lorem ipsum dolor sit.</p>
                    <p class="card-time"><span class="fas fa-clock"></span> 15-30 minutes</p>
                </div>
            </div>
            <div class="dashboard-card">
                <img class="card-image" src="https://images.immediate.co.uk/production/volatile/sites/30/2014/05/Epic-summer-salad-hub-2646e6e.jpg">
                <div class="card-detail">
                    <h4>Fresh Salad<span>$30</span></h4>
                    <p>Lorem ipsum dolor sit.</p>
                    <p class="card-time"><span class="fas fa-clock"></span> 15-30 minutes</p>
                </div>
            </div>
            <div class="dashboard-card">
                <img class="card-image" src="https://static.onecms.io/wp-content/uploads/sites/43/2022/02/16/21014-Good-old-Fashioned-Pancakes-mfs_001.jpg">
                <div class="card-detail">
                    <h4>Sweet Pancake<span>$30</span></h4>
                    <p>Lorem ipsum dolor sit.</p>
                    <p class="card-time"><span class="fas fa-clock"></span> 15-30 minutes</p>
                </div>
            </div>
            <div class="dashboard-card">
                <img class="card-image" src="https://www.seriouseats.com/thmb/WzQz05gt5witRGeOYKTcTqfe1gs=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/butter-basted-pan-seared-steaks-recipe-hero-06-03b1131c58524be2bd6c9851a2fbdbc3.jpg">
                <div class="card-detail">
                    <h4>Steak<span>$30</span></h4>
                    <p>Lorem ipsum dolor sit.</p>
                    <p class="card-time"><span class="fas fa-clock"></span> 15-30 minutes</p>
                </div>
            </div>
            <div class="dashboard-card">
                <img class="card-image" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLY5j-0GxBdLWv53oNAH6KKQszBRTDWstPXg&usqp=CAU">
                <div class="card-detail">
                    <h4>Healthy Breakfast<span>$30</span></h4>
                    <p>Lorem ipsum dolor sit.</p>
                    <p class="card-time"><span class="fas fa-clock"></span> 15-30 minutes</p>
                </div>
            </div>
            <div class="dashboard-card">
                <img class="card-image" src="https://assets.epicurious.com/photos/5c745a108918ee7ab68daf79/1:1/w_2560%2Cc_limit/Smashburger-recipe-120219.jpg">
                <div class="card-detail">
                    <h4>Fantastic Burger<span>$30</span></h4>
                    <p>Lorem ipsum dolor sit.</p>
                    <p class="card-time"><span class="fas fa-clock"></span> 15-30 minutes</p>
                </div>
            </div>
        </div>
    </div>

    <!-- Order Dashboard -->
    <div class="dashboard-order" style="padding-top:90px;">
        <h3>Order Menu</h3>
        <div class="order-address">
            <p>Address Delivery</p>
            <h4>221 B Baker Street, Philippines</h4>
        </div>
        <div class="order-time">
            <span class="fas fa-clock"></span>30 minutes <span class="fas fa-map-marker-alt">2km</span>
        </div>

        <div class="order-wrapper">
            <div class="order-card">
                <img class="order-image" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLY5j-0GxBdLWv53oNAH6KKQszBRTDWstPXg&usqp=CAU">
                <div class="order-detail">
                    <p>Lorem ipsum dolor sit amet.</p>
                    <i class="fas fa-times"></i> <input type="text" value="1">
                </div>
                <h4 class="order-price">$35</h4>
            </div>
            <div class="order-card">
                <img class="order-image" src="https://images.immediate.co.uk/production/volatile/sites/30/2014/05/Epic-summer-salad-hub-2646e6e.jpg">
                <div class="order-detail">
                    <p>Lorem ipsum dolor sit amet.</p>
                    <i class="fas fa-times"></i> <input type="text" value="2">
                </div>
                <h4 class="order-price">$35</h4>
            </div>
            <div class="order-card">
                <img class="order-image" src="https://assets.epicurious.com/photos/5c745a108918ee7ab68daf79/1:1/w_2560%2Cc_limit/Smashburger-recipe-120219.jpg">
                <div class="order-detail">
                    <p>Lorem ipsum dolor sit amet.</p>
                    <i class="fas fa-times"></i> <input type="text" value="3">
                </div>
                <h4 class="order-price">$23</h4>
            </div>
        </div>
        <hr class="divider">
        <button class="checkout">
            Checkout
        </button>

    </div>

	<%@ include file="footer.jsp"%>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="https://cdn.reflowhq.com/v2/toolkit.min.js"></script>
<script src="assets/js/bs-init.js"></script>
<script src="assets/js/theme.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>