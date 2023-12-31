<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
    <style>
        /* Custom styles */
        .body {
            background-color: #f8f9fa;
        }

        .dashboard-container {
            margin-top: 50px;
        }

        .notification-column {
            background-color: #fff;
            padding: 20px;
            height: 400px;
            overflow-y: scroll;
        }

        .orders-column {
            background-color: #fff;
            padding: 20px;
            height: 400px;
            overflow-y: scroll;
        }

        .menu-column {
            background-color: #fff;
            padding: 20px;
            margin-bottom: 30px;
        }

        .menu-items {
            display: flex;
            flex-wrap: wrap;
        }

        .menu-form {
            margin-bottom: 20px;
        }

        .menu-item {
            flex-basis: 50%;
            padding: 10px;
            background-color: #f8f9fa;
            border-radius: 5px;
            position: relative;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .menu-item img {
            max-width: 100%;
            height: auto;
            border-radius: 5px;
            margin-bottom: 10px;
        }

        .background-design {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-repeat: no-repeat;
            background-position: center;
            background-size: cover;
            z-index: -1;
        }

        .background-design-1 {
            background-image: url('background-1.jpg');
        }

        .background-design-2 {
            background-image: url('background-2.jpg');
        }
    </style>
    <title>Meals on Wheels Dashboard</title>
</head>

<body>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top mb-5" id="mainNav" style="background-color: black;">
    <div class="container">
        <h1 class="text-white fs-2">MOW</h1>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars ms-1"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                <li class="nav-item"><a class="nav-link" href="kitchen.html">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="body container pt-5 pb-5 mt-5">
    <div class="row dashboard-container">
        <!-- Notification and Orders Column -->
        <div class="col-md-4">
            <div class="notification-column">
                <h5 class="mb-3"><i class="fas fa-bell"></i> Notifications</h5>
                <div>
                    <div class="alert alert-info">New order received</div>
                    <div class="alert alert-info">Delivery scheduled</div>
                    <!-- Add more notifications here -->
                </div>
            </div>
            <div class="orders-column mt-4">
                <h5 class="mb-3"><i class="fas fa-clipboard-list"></i> Orders</h5>
                <div>
                    <h6>Ongoing Orders</h6>
                    <div class="order-item">
                        <span class="badge badge-primary">Order #1234</span>
                    </div>
                    <div class="order-item">
                        <span class="badge badge-primary">Order #5678</span>
                    </div>
                    <!-- Add more ongoing orders here -->
                </div>
                <div class="mt-4">
                    <h6>To Be Delivered</h6>
                    <div class="order-item">
                        <span class="badge badge-secondary">Order #9876</span>
                    </div>
                    <!-- Add more to be delivered orders here -->
                </div>
            </div>
        </div>

        <!-- Menu Column -->
        <div class="col-md-8 menu-column">
            <h5 class="mb-3"><i class="fas fa-utensils"></i> Menu</h5>
            <div>
                <div class="menu-item">
                    <img src="https://i.pinimg.com/736x/f2/5d/27/f25d278f1d70ba7feb3e889693144951.jpg" alt="Chicken Parmesan">
                    <h6>Chicken Parmesan</h6>
                    <em>Chicken, Parmesan cheese, Tomato sauce</em>
                </div>
                <div class="menu-item">
                    <img src="https://i.pinimg.com/564x/39/30/26/3930269ef2be9e70e52efe9d9dc88347.jpg"
                         alt="Spaghetti Bolognese">
                    <h6>Spaghetti Bolognese</h6>
                    <em>Spaghetti, Ground beef, Tomato sauce</em>
                </div>
                <!-- Add more menu items here -->
            </div>
            <button type="button" class="btn btn-secondary mt-3" data-bs-toggle="modal" data-bs-target="#addMenuModal" id="addMenuModalButton">
                <i class="fas fa-plus"></i> Add Menu
            </button>
        </div>

    </div>
</div>

<div class="background-design background-design-1"></div>
<div class="background-design background-design-2"></div>

<!-- Add Menu Modal -->
<div class="modal fade" id="addMenuModal" tabindex="-1" aria-labelledby="addMenuModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addMenuModalLabel"><i class="fas fa-plus"></i> Add Menu</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="menuName">Menu Name</label>
                        <input type="text" class="form-control" id="menuName" required>
                    </div>
                    <div class="form-group">
                        <label for="menuIngredients">Ingredients</label>
                        <textarea class="form-control" id="menuIngredients" rows="3" required></textarea>
                    </div>
                    <div class="form-group">
                        <label for="menuPrice">Price</label>
                        <input type="text" class="form-control" id="menuPrice" required>
                    </div>
                    <div class="form-group">
                        <label for="menuImage">Upload Image</label>
                        <input type="file" class="form-control-file" id="menuImage">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary">Add</button>
            </div>
        </div>
    </div>
</div>


<footer class="text-center text-lg-start text-muted" style="background-color: black;">

    <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
        <div class="me-5 d-none d-lg-block">
            <span class="text-white">Contact us through our social networking sites:</span>
        </div>
        <div>
            <a href="" class="me-4 text-reset"> <i class="fab fa-facebook-f text-white"></i>
            </a> <a href="" class="me-4 text-reset"> <i class="fab fa-twitter text-white"></i>
        </a> <a href="" class="me-4 text-reset"> <i class="fab fa-google text-white"></i>
        </a> <a href="" class="me-4 text-reset"> <i class="fab fa-instagram text-white"></i>
        </a> <a href="" class="me-4 text-reset"> <i class="fab fa-linkedin text-white"></i>
        </a> <a href="" class="me-4 text-reset"> <i class="fab fa-github text-white"></i>
        </a>
        </div>

    </section>

    <section class="">
        <div class="container text-center text-md-start mt-5">

            <div class="row mt-3">

                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                    <h6 class="text-uppercase fw-bold mb-4 text-white">
                        <i class="fas fa-gem me-3 text-white"></i>Meals On Wheels
                    </h6>
                    <p class="text-white">Nourishing Lives: Meals on Wheels Delivers Care and Support</p>
                </div>

                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4" id="links">
                    <h6 class="text-uppercase fw-bold mb-4 text-white">Meals</h6>
                    <p>
                        <a href="cars" class="text-white text-decoration-none">Menu</a>
                    </p>
                    <p>
                        <a href="cars" class="text-white text-decoration-none">Partners</a>
                    </p>
                </div>

                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4" id="links">
                    <h6 class="text-uppercase fw-bold mb-4 text-white">Meals On Wheels</h6>
                    <p>
                        <a href="about_us" class="text-white text-decoration-none">About Us</a>
                    </p>
                    <p>
                        <a href="contact_us" class="text-white text-decoration-none">Contact Us</a>
                    </p>

                </div>

                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                    <h6 class="text-uppercase fw-bold mb-4 text-white">Contact</h6>
                    <p class="text-white">
                        <i class="fas fa-home me-3 text-white"></i> Philippines, CEBU 10286, PH
                    </p>
                    <p class="text-white">
                        <i class="fas fa-envelope me-3 text-white"></i> mealsonwheels.com
                    </p>
                    <p class="text-white">
                        <i class="fas fa-phone me-3 text-white"></i> + 09 186 562 54
                    </p>
                    <p class="text-white">
                        <i class="fas fa-print me-3 text-white"></i> + 09 825 660 09
                    </p>
                </div>
            </div>
        </div>
    </section>
    <div class="text-center p-4 text-white" style="background-color: rgba(0, 0, 0, 0.05);">
        &copy; 2023 Copyright: <a class="text-reset fw-bold text-white" href="#">mealsonwheels.com</a>
    </div>
</footer>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script>
    // Wait for the DOM to load
    document.addEventListener('DOMContentLoaded', function() {
        // Get the "Add Menu" button
        var addMenuButton = document.querySelector('#addMenuModalButton');

        // Get the modal
        var addMenuModal = new bootstrap.Modal(document.getElementById('addMenuModal'));

        // Attach a click event listener to the button
        addMenuButton.addEventListener('click', function() {
            // Show the modal
            addMenuModal.show();
        });
    });
</script>


</body>

</html>