<%@ page import="com.Group1.MealsOnWheels.Entity.Meal_Order" %>
<%@ page import="com.Group1.MealsOnWheels.Entity.Meal" %>
<%@ page import="com.Group1.MealsOnWheels.Entity.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
	<title>Admin Dashboard</title>
	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet"
		  href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
	<link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
	<link rel="stylesheet"
		  href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<link rel="stylesheet"
		  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
	<!-- Favicon-->
	<link href="https://cdn-icons-png.flaticon.com/512/7541/7541900.png"
		  rel="icon">
	<!-- Font Awesome icons (free version)-->
	<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
			crossorigin="anonymous"></script>
	<!-- Google fonts-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
		  rel="stylesheet" type="text/css" />
	<link
			href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700"
			rel="stylesheet" type="text/css" />
	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="css/styles.css" rel="stylesheet" />
</head>

<body id="page-top" class="dark-mode">

<%@ include file="header.jsp"%>

<div id="wrapper" class="container">
	<div class="d-flex flex-column" id="content-wrapper">
		<div id="content">
			<div class="container-fluid">
				<div
						class="d-sm-flex justify-content-between align-items-center mb-4"
						style="margin-bottom: 0px; margin-top: 16px;">
					<h3 class="text-dark mb-0">Dashboard</h3>
				</div>
				<% User user = (User) request.getAttribute("loggedUser"); %>
                
				<div class="row">
					<div class="col-md-6 col-xl-6 col-xxl-6 mb-4">
						<div class="card shadow border-start-primary py-2">
							<div class="card-body">
								<div class="row align-items-center no-gutters ps-3">
									<div class="col-auto">
										<img src="assets/img/avatars/avatar3.jpeg">
									</div>
									<div class="col me-2 ps-3">
										<div class="text-uppercase text-secondary fw-bold text-xs mb-1 fs-5">
											<span><%= user.getName() %></span>
										</div>
										<span>Admin</span>
										<div class="text-dark fw-bold h5 mb-0"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-xl-6 col-xxl-6 mb-4">
						<div class="card shadow border-start-primary py-2">
							<div class="card-body">
								<div class="row align-items-center no-gutters ps-3">
									<div class="col me-2 ps-3 d-flex justify-content-between" style="padding-top:13px; padding-bottom:13px;">
										<span>Total Donations:</span>
										<span class="text-uppercase text-secondary fw-bold text-xs mb-1 fs-5 pe-3">$</span>
										<span class="text-uppercase text-secondary fw-bold text-xs mb-1 fs-5 pe-3" id="totalAmount"></span>
									</div>
								</div>
								<!-- <script type="text/javascript">
									$(document).ready(function() {
										$.ajax({
											url: '/api/allfunds/',
											type: 'GET',
											success: function(data) {
												let tableBody = $('#fundsTable tbody');
												let totalAmount = 0;
												data.forEach(function(fund) {
													let row = $('<tr></tr>');
													row.append($('<td></td>').text(fund.f_id));
													row.append($('<td></td>').text(fund.name));
													row.append($('<td></td>').text(fund.amount));
													row.append($('<td></td>').text(fund.dateTime));
													tableBody.append(row);
													totalAmount += parseInt(fund.amount); // Parse amount as an integer
												});
												$('#totalAmount').text(totalAmount);
											}
										});
										function updateDonations() {
											$.ajax({
												url: '/api/allfunds',
												type: 'GET',
												success: function(data) {
													let tableBody = $('#fundsTable tbody');
													let totalAmount = 0;
													tableBody.empty(); // Clear the table body

													data.forEach(function(donation) {
														let row = $('<tr></tr>');
														row.append($('<td></td>').text(donation.f_id));
														row.append($('<td></td>').text(donation.name));
														row.append($('<td></td>').text(donation.amount));
														row.append($('<td></td>').text(donation.dateTime));
														tableBody.append(row);
														totalAmount += parseInt(donation.amount);
													});

													$('#totalAmount').text(totalAmount);
												}
											});
										}
										updateDonations();
										setInterval(updateDonations, 10000);
									});
								</script> -->
							</div>
						</div>
					</div>

					<div class="row">

								
						<!-- Orders -->
								<div class="col-lg-6 col-xxl-4 offset-xxl-0 mb-4">
								    <div class="card shadow mb-4"></div>
								    <div class="card shadow mb-4">
								        <div class="card-header py-3">
								            <h6 class="text-secondary fw-bold m-0">All Orders</h6>
								            
								            
								        </div>
								        <div class="order-wrapper" style="height:500px;">
								            <% List<Meal_Order> ordered = (List<Meal_Order>) request.getAttribute("ordered"); %>
								            <% if (ordered != null && !ordered.isEmpty()) { %>
								                <% for (Meal_Order meal : ordered) { %>
								                    <div class="order-card">
								                        <div class="d-flex justify-content-between">
								                            <% List<Meal> mealResult = (List<Meal>) request.getAttribute("mealResults"); %>
								                            <% for (Meal mealOrdered : mealResult) { %>
								                                <% if (meal.getM_id() == mealOrdered.getM_id()) { %>
								                                    <div class="d-flex justify-content-start ms-3 mb-3">
								                                        <img class="order-image" src="<%= mealOrdered.getPhotoPath() %>">
								                                        <div class="order-detail ms-3">
								                                            <p class="fw-bold mb-0" style="font-size:1em;"><%= mealOrdered.getMeal_name() %></p>
								                                            <span style="font-size:0.8em;">Member Id: <%= meal.getU_id() %></span>
								                                            <span style="font-size:0.8em;">| Partner Id: <%= meal.getP_id() %></span>
								                                            <span style="font-size:0.8em;"><%= meal.getOrder_date() %></span>
								                                        </div>
								                                    </div>
								                                    <input type="hidden" name="mealId" id="mealId" value="<%= meal.getM_id() %>">
								                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
								                                    <button class="btn btn-success float-end" data-bs-toggle="modal" data-bs-target="#adminAccept" style="height:50%" type="button">Accept</button>
								                                	<!-- Modal -->
																	<div class="modal fade" id="adminAccept" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
																	  <div class="modal-dialog">
																	    <div class="modal-content">
																	      <div class="modal-header">
																	        <h1 class="modal-title fs-5" id="exampleModalLabel">Order Manager</h1>
																	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
																	      </div>
																	      <div class="modal-body">
																	        <div class="modal-body">
																				  <form action="adminAccepts" method="post" id="distance-form">
																				    <label htmlFor="mealOrder">Meal Order #:</label>
																				    <input class="form-control" type="text" id="orderId" name="orderId" value="<%= meal.getMo_id() %>"></input>
																				    	
																					<% List<User> partners = (List<User>) request.getAttribute("partners"); %>
																				    <div class="dropdown mb-5">
																				      <% if (partners != null && !partners.isEmpty()) { %>
																				      <label htmlFor="partner">Select a Partner:</label>
																				      <select id="selectedPartner" name="selectedPartner" class="dropdown-center dropdown-menu d-grid text-center mb-3" onchange="updateDestinationAddress(this)">
																				        <% for (User partner : partners) { %>
																				        <option class="dropdown-item" style="width:100%" value="<%= partner.getId()%>" data-address="<%= user.getAddress() %>">
																				          <%= partner.getName() %>
																				        </option>
																				        <% } %>
																				      </select>
																				      <% } %>
																				    </div>
																				    <label htmlFor="origin">Member Location:</label>
																				    <input disabled class="form-control" type="text" id="origin" name="origin" placeholder="Distance From" value="<%= meal.getTo_address() %>">
																				    <label htmlFor="destination">Partner Location:</label>
																				    <input class="form-control" type="text" id="destination" name="destination" placeholder="Choose Partner to set location.">
																				    <div id="loading-icon" style="display: none;">Loading...</div>
																				    <div id="distance-results"></div>
																				    <div id="map"></div>
																				    <input class="btn btn-warning rounded mt-3 col-12" type="submit" value="Submit">
																				  </form>
</div>
																	        
																	      </div>
																	      <div class="modal-footer">
																	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
																	        <button type="button" class="btn btn-primary">Save changes</button>
																	      </div>
																	    </div>
																	  </div>
																	</div>
								                                
								                                
								                                <% } %>
								                            <% } %>
								                        </div>
								                    </div>
								                <% } %>
								            <% } %>
								        </div>
								    </div>
								</div>
<!-- 
						<ul class="list-group list-group-flush order-wrapper" style="height:500px;" id="ordersContainer">
									Orders will be dynamically added here
								</ul>
 -->
						<!-- Orders (JSON) -->
						<script>
							$(document).ready(function() {
								$.ajax({
									url: '/orders/all',
									type: 'GET',
									dataType: 'json',
									success: function(data) {
										let container = $('#allOrdersList');
										let totalAmount = 0;

										data.sort(function(b, a) {
											return new Date(a.order_date) - new Date(b.order_date);
										});

										data.forEach(function(order) {
											let orderContainer = $('<div class="card"></div>');
											let cardBody = $('<div class="row card-body"></div>');

											cardBody.append($('<p class="card-text col-6"></p>').text('Meal Id: ' + order.mo_id));
											cardBody.append($('<p class="card-text col-6"></p>').text('Order Number: ' + order.order_number));
											cardBody.append($('<p class="card-text col-6"></p>').text('Member Id: ' + order.m_id));
											cardBody.append($('<p class="card-text col-6"></p>').text('Date: ' + order.order_date));
											cardBody.append($('<p class="card-text col-6"></p>').html('Status: <strong>' + order.status + '</strong>'));

											orderContainer.append(cardBody);
											container.append(orderContainer);
										});

									},
									error: function(xhr, status, error) {
										console.error('Error:', error);
									}
								});
							});

						</script>

						<!-- All Orders -->
						<div class="col-lg-6 col-xxl-4 offset-xxl-0 mb-4">
						    <div class="card shadow mb-4"></div>
						    <div class="card shadow mb-4">
						        <div class="card-header py-3">
						            <h6 class="text-secondary fw-bold m-0">All Orders</h6>
						        </div>
						        <div class="order-wrapper" style="height:500px;">
						            <% List<Meal_Order> deliveredOrders = (List<Meal_Order>) request.getAttribute("deliveredOrders"); %>
						            <% if (deliveredOrders != null && !deliveredOrders.isEmpty()) { %>
						                <% for (Meal_Order meal : deliveredOrders) { %>
						                    <div class="order-card">
						                        <div class="d-flex justify-content-between">
						                            <% List<Meal> mealResult = (List<Meal>) request.getAttribute("mealResults"); %>
						                            <% for (Meal mealOrdered : mealResult) { %>
						                                <% if (meal.getM_id() == mealOrdered.getM_id()) { %>
						                                    <div class="d-flex justify-content-start ms-3 mb-3">
						                                        <img class="order-image" src="<%= mealOrdered.getPhotoPath() %>">
						                                        <div class="order-detail ms-3">
						                                            <p class="fw-bold mb-0" style="font-size:1em;"><%= mealOrdered.getMeal_name() %></p>
						                                            <span style="font-size:0.8em;">Member Id: <%= meal.getU_id() %></span>
						                                            <span style="font-size:0.8em;">| Partner Id: <%= meal.getP_id() %></span>
						                                            <span style="font-size:0.8em;"><%= meal.getOrder_date() %></span>
						                                        </div>
						                                    </div>
						                                    <input type="hidden" name="mealId" id="mealId" value="<%= meal.getM_id() %>">
						                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
						                                    <button type='submit' class="order-price text-danger d-flex justify-content-end btn" style="width:113px;">
						                                        <p style="font-size:0.8em;" class="mb-0">Status: <%= meal.getStatus() %></p>
						                                    </button>
						                                <% } %>
						                            <% } %>
						                        </div>
						                    </div>
						                <% } %>
						            <% } %>
						        </div>
						    </div>
						</div>

					
	        

						<!-- Donations (JSON) -->
						<script type="text/javascript">
							$(document).ready(function() {
								$.ajax({
									url: '/api/allfunds',
									type: 'GET',
									success: function(data) {
										let container = $('#donationContainer');
										let donationsList = $('#donationsList');
										let totalAmount = 0;

										data.sort(function(b, a) {
											return new Date(a.dateTime) - new Date(b.dateTime);
										});

										data.forEach(function(donation) {
											let donationItem = $('<div class="alert alert-info"></div>');
											let date = new Date(donation.dateTime);
											let formattedDate = date.toLocaleDateString('en-US');
											donationItem.text(donation.name + ' donated $' + donation.amount + ' on ' + formattedDate);
											donationsList.append(donationItem);
											totalAmount += parseInt(donation.amount);
										});



										$('#totalAmount').text(totalAmount);
									}
								});
							});
						</script>

						<!-- Donations (Notification)  -->
						<div class="col-lg-6 col-xxl-4 mb-4">
							<div class="card shadow mb-4"></div>
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="text-secondary fw-bold m-0"
										style="color: rgb(45, 237, 42);">Notification</h6>
								</div>
								<div class="alert alert-info" style="background-color: white;" id="donationsList"></div>
								<!-- Add more notifications here -->
							</div>
						</div>
					</div>

					<!-- Orders (JSON) -->
					<script>
						$(document).ready(function() {
							$.ajax({
								url: '/orders/pendingOrders',
								type: 'GET',
								dataType: 'json',
								success: function(data) {
									let container = $('#ordersContainer');
									let totalAmount = 0;

									data.sort(function(b, a) {
										return new Date(a.order_date) - new Date(b.order_date);
									});

									data.forEach(function(order) {
										let orderContainer = $('<div class="card"></div>');
										let cardBody = $('<div class="row card-body"></div>');

										cardBody.append($('<p class="col-6 card-text"></p>').text('Meal Order Id: ' + order.mo_id));
										cardBody.append($('<p class="col-6 card-text"></p>').text('Order Number: ' + order.order_number));
										cardBody.append($('<p class="col-6 card-text"></p>').text('Meal Id: ' + order.m_id));
										cardBody.append($('<p class="col-6 card-text"></p>').text('Member Id: ' + order.u_id));
										cardBody.append($('<p class="col-6 card-text"></p>').text('Date: ' + order.order_date));
										cardBody.append($('<p class="col-6 card-text"></p>').html('Status: <strong>' + order.status + '</strong>'));

										// Create the button
										let acceptButton = $('<button class="btn btn-success float-end" type="button">Accept</button>');


								        // Set the data attributes with the meal information
								        acceptButton.data('meal-id', order.mo_id);
								        acceptButton.data('order-number', order.order_number);
								        acceptButton.data('member-id', order.m_id);
								        acceptButton.data('from-address', order.from_address);
								        acceptButton.data('partner-id', order.p_id);
								        

								         acceptButton.on('click', function() {
								          // Access the meal information from the data attributes
								          let mealId = $(this).data('meal-id');
								          let orderNumber = $(this).data('order-number');
								          let memberId = $(this).data('member-id');
								          let fromAddress = $(this).data('from-address');
								          let partnerId = $(this).data('partner-id');
											// Create the modal
											let modal = $('<div class="modal fade" tabindex="-1"></div>');
											let modalDialog = $('<div class="modal-dialog"></div>');
											let modalContent = $('<div class="modal-content"></div>');
											let modalHeader = $('<div class="modal-header"></div>');
											
											<% List<User> partners = (List<User>) request.getAttribute("partners"); %>
											//Here Dimps
											let modalBody = $('<div class="modal-body"><form action="adminAccepts" method="post" id="distance-form"><label htmlFor="mealOrder">Meal Order #: </label><input class="form-control" type="text" id="orderId" name="orderId" value="'+ mealId +'""></input><div class="dropdown mb-5"><% if (partners != null && !partners.isEmpty()) { %><label htmlFor="partner">Select a Partner:</label><select id="selectedPartner" name="selectedPartner" class="dropdown-center dropdown-menu d-grid text-center mb-3" onchange="updateDestinationAddress(this)"><% for (User partner : partners) { %><option class="dropdown-item" style="width:100%" value="<%= partner.getId()%>" data-address="<%= user.getAddress() %>"><%= partner.getName() %></option><% } %></select><% } %></div><label htmlFor="origin">Member Location: </label><input disabled class="form-control" type="text" id="origin" name="origin" placeholder="Distance From" value="' + fromAddress + '"><label htmlFor="destination">Partner Location: </label><input class="form-control" type="text" id="destination" name="destination" placeholder="Choose Partner to set location."><div id="loading-icon" style="display: none;">Loading...</div><div id="distance-results"></div><div id="map"></div><input class="btn btn-warning rounded mt-3 col-12" type="submit" value="Submit"></form></div>');
											let modalFooter = $('<div class="modal-footer"></div>');

											// Add content to the modal
											modalHeader.append($('<h5 class="modal-title">Order Manager</h5>'));
											modalFooter.append($('<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>'));

											// Append the modal elements
											modalContent.append(modalHeader);
											modalContent.append(modalBody);
											modalContent.append(modalFooter);
											modalDialog.append(modalContent);
											modal.append(modalDialog);

											// Show the modal
											$('body').append(modal);
											modal.modal('show');


											// Retrieve the list of partners from the server
											$.ajax({
												url: '/orders/partners',
												type: 'GET',
												success: function(data) {
													let partnerText = $('<p></p>').text('Select a kitchen to accept the order:');
													modalBody.append(partnerText);
													let partnersDropdown = $('<select></select>');
													data.forEach(function(partner) {
														partnersDropdown.append($('<option></option>').val(partner.p_id).text(partner.name + ', ' + partner.address));
													});
													modalBody.append(partnersDropdown);

													// Create the "Send to Kitchen" button
													let sendToKitchenButton = $('<button class="btn btn-primary mt-3">Send to Kitchen</button>');
													sendToKitchenButton.on('click', function() {
														let selectedPartnerId = partnersDropdown.val();
														$.ajax({
															url: '/orders/acceptOrder',
															type: 'POST',
															data: {
																orderNumber: order.order_number,
																partnerId: selectedPartnerId
															},
															success: function(data) {
																alert('Order accepted!');
																location.reload();
															}
														});
													});
													modalFooter.append(sendToKitchenButton);
												}
											});
										});

										cardBody.append(acceptButton);

										orderContainer.append(cardBody);
										container.append(orderContainer);
									});

								},
								error: function(xhr, status, error) {
									console.error('Error:', error);
								}
							});
						}); 
					</script>


				</div>
			</div>
		</div>
	</div>
</div>
<script>
    function initMap() {
        var mapOptions = {
            center: { lat: 0, lng: 0 }, // Default center at (0, 0)
            zoom: 12 // Adjust the zoom level as needed
        };
        var map = new google.maps.Map(document.getElementById('map'), mapOptions);

        var marker;

        map.addListener('click', function(event) {
            placeMarker(event.latLng);
        });

        function placeMarker(location) {
            if (marker) {
                marker.setMap(null); // Remove the existing marker
            }
            marker = new google.maps.Marker({
                position: location,
                map: map
            });
            updateAddress(location);
        }

        function updateAddress(location) {
            var geocoder = new google.maps.Geocoder();
            geocoder.geocode({ 'latLng': location }, function(results, status) {
                if (status === 'OK') {
                    if (results[0]) {
                        var address = results[0].formatted_address;
                        document.getElementById("origin").value = address;
                        map.setCenter(location); // Set the map center to the clicked location
                    } else {
                        alert('No results found');
                    }
                } else {
                    alert('Geocoder failed due to: ' + status);
                }
            });
        }
    }
    
    function updateDestinationAddress(element) {
    	
    	let selectedValue = $('#selectedPartner').val();
        $('#destination').val(selectedValue);

        document.getElementById("loading-icon").style.display = "block";
        
        let selectedOption = element.options[element.selectedIndex];
        let selectedAddress = selectedOption.getAttribute('data-address');
        document.getElementById('destination').value = selectedAddress;


        var origin = encodeURIComponent(document.getElementById("origin").value);
        var destination = encodeURIComponent($('#destination').val());

	        var xhr = new XMLHttpRequest();
	        xhr.open("POST", "/api/" + origin + "/" + destination, true);
	        xhr.onreadystatechange = function() {
	            if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
	                // Hide the loading icon
	                document.getElementById("loading-icon").style.display = "none";

	                var response = JSON.parse(xhr.responseText);
	                displayDistance(response);
	            } else if (xhr.readyState === XMLHttpRequest.DONE) {
	                // Hide the loading icon
	                document.getElementById("loading-icon").style.display = "none";

	                alert("Error retrieving distance.");
	            }
	        };
	        xhr.send();
	        
		}

    function displayDistance(response) {
        var distanceResults = document.getElementById("distance-results");
        distanceResults.innerHTML = "";

        var distanceFrom = document.createElement("div");
        distanceFrom.textContent = "Distance From: " + response.From;
        distanceResults.appendChild(distanceFrom);

        var distanceTo = document.createElement("div");
        distanceTo.textContent = "Distance To: " + response.To;
        distanceResults.appendChild(distanceTo);

        var kilometerDistance = document.createElement("div");
        kilometerDistance.textContent = "Distance in Kilometers: " + response.Distance;
        distanceResults.appendChild(kilometerDistance);

        var timeOfArrival = document.createElement("div");
        timeOfArrival.textContent = "Time of Arrival: " + response.Duration;
        distanceResults.appendChild(timeOfArrival);

        var foodStatus = document.createElement("div");
        foodStatus.textContent = "Food Status: " + response.Status;
        distanceResults.appendChild(foodStatus);
    }
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap" async defer></script>


<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/theme.js"></script>
</body>

</html>