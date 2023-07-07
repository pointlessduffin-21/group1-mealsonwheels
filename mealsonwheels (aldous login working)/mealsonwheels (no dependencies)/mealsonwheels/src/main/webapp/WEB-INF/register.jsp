<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="align-items-center position-relative" style="height: 100vh; overflow: hidden">
    <img class="position-absolute" style="width:100%" src="/assets/img/pot.jpg"/>
    <h1 class="text-white text-center ps-5 pt-5 pb-0 mb-0" style="font-size: 3em; font-weight: 700; position: relative; top: 0px" >REGISTRATION</h1>

    <div class='container mt-5 border p-5 pt-0 rounded' style="width: 50%; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); background-color: rgba(255, 255, 255, 0.5)">


        <div class='row justify-content-evenly mt-5'>
            <hr class="col-3 py-2 mb-0"></hr>
            <p type="button" class="col-6 py-2 mb-0 text-center" style="position: relative; top: -20px">Don't have an account? Register Now!</p>
            <hr class="col-3 py-2 mb-0"></hr>
        </div>
        
        <div class="row d-flex justify-content-between">
	            <div class="dropdown-center col-6 d-grid mx-auto text-center mb-3">
				    <label htmlFor='role'>Choose a Role:</label>
				    <select id="user-role-dropdown" class="rounded text-center" style="padding-top:7px;padding-bottom:7px;">
					  <option value="Member" selected>Member</option>
					  <option value="Donator">Donator</option>
					  <option value="Volunteer">Volunteer</option>
					  <option value="Partner">Partner</option>
					</select>
					
				</div>
	   	</div>
        
        <!-- ADD ACTION ON FORMS -->
        <!-- THIS IS USER REGISTRATION -->

        <form class='m-2 user-reg' id="user-registration-form">
        
        <div class='row justify-content-evenly mt-5'>
            <hr class="col-3 py-2 mb-0"></hr>
            <p type="button" class="col-6 py-2 mb-0 text-center" style="position: relative; top: -20px">Registering as <span class="fw-bold" id="role-span">Member</span></p>
            <hr class="col-3 py-2 mb-0"></hr>
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
        
        
        
        <!-- THIS IS PARTNER REGISTRATION -->
        
        <form class='m-2 partner-reg' style="display: none;" id="partner-registration-form">
        
        <div class='row justify-content-evenly mt-5'>
            <hr class="col-3 py-2 mb-0"></hr>
            <p type="button" class="col-6 py-2 mb-0 text-center" style="position: relative; top: -20px">Registering as <span class="fw-bold" id="partner-span"></span></p>
            <hr class="col-3 py-2 mb-0"></hr>
        </div>

                <div class='form-group mb-3 col-12'>
                    <label htmlFor='name'>Name</label>
                    <input
                            type='text'
                            class='form-control'
                            id='name'
                    />
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

                <div class='form-group mb-3 col-12'>
                    <label htmlFor='contact'>Contact</label>
                    <input
                            type='text'
                            class='form-control'
                            id='contact'
                    />
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

<script>
const dropdown = document.getElementById("user-role-dropdown");
const form1 = document.getElementById("user-registration-form");
const form2 = document.getElementById("partner-registration-form");
const button = document.getElementById("partner-role-button");
const role = document.getElementById("role-span");
const partner = document.getElementById("partner-span");

dropdown.addEventListener("change", function() {
  const selectedValue = this.value;
  if (selectedValue === "Member") {
    form1.style.display = "block";
    form2.style.display = "none";
    role.innerText = selectedValue;
  } else if (selectedValue === "Donator") {
	    form1.style.display = "block";
	    form2.style.display = "none";
	    role.innerText = selectedValue;
  } else if (selectedValue === "Volunteer") {
	  //CHANGE TO THIS
	    form1.style.display = "none";
	    form2.style.display = "block";
	  // ENDS HERE
	    partner.innerText = selectedValue;
  } else if (selectedValue === "Partner"){
	  	form1.style.display = "none";
	  	form2.style.display = "block";
	    partner.innerText = selectedValue;
  }
}); 

</script>
</body>
</html>