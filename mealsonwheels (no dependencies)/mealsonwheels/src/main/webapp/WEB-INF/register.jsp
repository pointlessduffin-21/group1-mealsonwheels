<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meals on Wheels</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</head>
<body>

<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
        <h1 class="text-white fs-2">MOW</h1>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars ms-1"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                <li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="register.html">Register</a></li>
                <li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="align-items-center position-relative" style="height: 100vh; overflow: hidden">
    <img class="position-absolute" style="width:100%" src="/assets/img/pot.jpg"/>
    <h1 class="text-white text-center ps-5 pt-5 pb-0 mb-0" style="font-size: 3em; font-weight: 700; position: relative; top: 0px" >REGISTRATION</h1>

    <div class='container mt-5 border p-5 pt-0 rounded' style="width: 50%; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); background-color: rgba(255, 255, 255, 0.5)">


        <div class='row justify-content-evenly mt-5'>
            <hr class="col-3 py-2 mb-0"></hr>
            <p type="button" class="col-6 py-2 mb-0 text-center" style="position: relative; top: -20px">Don't have an account? Register!</p>
            <hr class="col-3 py-2 mb-0"></hr>
        </div>

        <form class='m-2'>

            <div class="dropdown-center col-3 mx-auto d-grid text-center mb-3">
                <label htmlFor='role'>Choose a Role:</label>
                <button style="height: 40px" class="btn btn-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    User Role
                </button>
                <ul class="dropdown-menu dropdown-menu-light">
                    <li><a class="dropdown-item active" href="#">Member</a></li>
                    <li><a class="dropdown-item" href="#">Donator</a></li>
                    <li><a class="dropdown-item" href="#">Volunteer/Rider</a></li>
                    <li><a class="dropdown-item" href="#">Caregiver</a></li>
                    <li><a class="dropdown-item" href="#">Kitchen</a></li>
                </ul>
            </div>

            <div class='row'>
                <div class='form-group mb-3 col-6'>
                    <label htmlFor='name'>Name</label>
                    <input
                            type='text'
                            class='form-control'
                            id='name'
                    />
                </div>

                <div class='form-group mb-3 col-6'>
                    <label htmlFor='username'>Username</label>
                    <input
                            type='text'
                            class='form-control'
                            id='username'
                    />
                </div>
            </div>

            <div class="row">
                <div class='form-group mb-3 col-6'>
                    <label htmlFor='email'>Email Address</label>
                    <input
                            type='email'
                            class='form-control'
                            id='email'
                    />
                </div>

                <div class='form-group mb-3 col-6'>
                    <label htmlFor='password'>Password</label>
                    <input
                            type='password'
                            class='form-control'
                            id='password'
                    />
                </div>
            </div>

            <div class='row'>
                <div class='form-group mb-3 col-6'>
                    <label htmlFor='age'>Age</label>
                    <input
                            type='text'
                            class='form-control'
                            id='age'
                    />
                </div>

                <div class='form-group mb-3 col-6'>
                    <label htmlFor='contact'>Contact</label>
                    <input
                            type='text'
                            class='form-control'
                            id='contact'
                    />
                </div>
            </div>

            <div class='form-group mb-3'>
                <label htmlFor='address'>Address</label>
                <input
                        type='text'
                        class='form-control'
                        id='address'
                />
            </div>

            <button type='submit' class='btn btn-outline-dark px-5 mt-3 col-12'>Register</button>

        </form>
    </div>
</div>
</body>
</html>