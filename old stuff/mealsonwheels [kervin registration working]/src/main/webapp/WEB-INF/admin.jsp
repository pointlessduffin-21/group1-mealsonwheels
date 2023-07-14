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
											<span>Harry Potter</span>
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
								<script type="text/javascript">
									$(document).ready(function() {
										$.ajax({
											url: '/funds/all',
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
												url: '/funds/all',
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
								</script>
							</div>
						</div>
					</div>

					<script>
						function changeStatus(status) {
							document.getElementById("status-btn").innerHTML = status;
							if (status === "Available") {
								document.getElementById("status-btn").style.backgroundColor = "#5ec58f";
							} else if (status === "Busy") {
								document.getElementById("status-btn").style.backgroundColor = "orange";
							} else if (status === "Offline") {
								document.getElementById("status-btn").style.backgroundColor = "grey";
							}
						}
					</script>

					<div class="row">
						<!--Notification  -->
						<div class="col-lg-6 col-xxl-4 mb-4">
							<div class="card shadow mb-4"></div>
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="text-secondary fw-bold m-0"
										style="color: rgb(45, 237, 42);">Notification</h6>
								</div>
								<div>
									<div class="alert alert-info">New order received</div>
									<div class="alert alert-info">Delivery scheduled</div>
									<!-- Add more notifications here -->
								</div>
							</div>
						</div>

						<!-- Orders -->
						<div class="col-lg-6 col-xxl-4 mb-4">
							<div id="ordersContainer" class="no-gutters"></div>
						</div>

						<div class="col-lg-6 col-xxl-4 offset-xxl-0 mb-4">
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="text-secondary fw-bold m-0">Donations</h6>
								</div>
								<ul class="list-group list-group-flush ps-3" id="donationsList">
									<!-- Donations will be dynamically added here -->
								</ul>
							</div>
						</div>

						<script type="text/javascript">
							$(document).ready(function() {
								$.ajax({
									url: '/funds/all',
									type: 'GET',
									success: function(data) {
										let donationsList = $('#donationsList');
										let totalAmount = 0;

										data.forEach(function(donation) {
											let donationItem = $('<li class="list-group-item"></li>');
											let donationRow = $('<div class="row align-items-center no-gutters"></div>');
											let donationDetails = $('<div class="col-xxl-7 me-2"></div>');

											donationDetails.append($('<p></p>').text('Donation #' + donation.d_id));
											donationDetails.append($('<h6 class="mb-0"></h6>').html('<strong>' + donation.name + '</strong>'));
											donationDetails.append($('<p></p>').text(donation.location));
											donationDetails.append($('<p></p>').text('$' + donation.amount));

											donationRow.append(donationDetails);

											let donationActions = $('<div class="col-xxl-4 offset-xxl-0"></div>');
											let acceptButton = $('<button class="btn btn-success" type="button" style="width: 126.037px; padding: 6px 12px; margin: 10px;">Accept</button>');

											donationActions.append(acceptButton);

											donationRow.append(donationActions);

											donationItem.append(donationRow);
											donationsList.append(donationItem);

											totalAmount += parseInt(donation.amount);
										});

										$('#totalAmount').text(totalAmount);

										// Add boxes based on the amount of donations
										let numDonations = data.length;
										let numBoxes = Math.ceil(numDonations / 3); // Assuming 3 donations per box

										for (let i = 0; i < numBoxes; i++) {
											let box = $('<div class="card shadow mb-4"></div>');
											let boxHeader = $('<div class="card-header py-3"></div>');
											let boxTitle = $('<h6 class="text-secondary fw-bold m-0">Donations Box ' + (i + 1) + '</h6>');

											boxHeader.append(boxTitle);
											box.append(boxHeader);

											let boxList = $('<ul class="list-group list-group-flush ps-3"></ul>');
											for (let j = i * 3; j < (i + 1) * 3 && j < numDonations; j++) {
												boxList.append(donationsList.children().eq(j).clone());
											}

											box.append(boxList);
											donationsList.after(box);
										}
									}
								});
							});
						</script>

						<script>
							$(document).ready(function() {
								$.ajax({
									url: '/orders/pendingOrders',
									type: 'GET',
									dataType: 'json',
									success: function(data) {
										let container = $('#ordersContainer');
										let totalAmount = 0;

										data.forEach(function(order) {
											let orderContainer = $('<div class="card mb-3"></div>');
											let cardBody = $('<div class="card-body"></div>');

											cardBody.append($('<p class="card-text"></p>').text('Meal Id: ' + order.mo_id));
											cardBody.append($('<p class="card-text"></p>').text('Order Number: ' + order.order_number));
											cardBody.append($('<p class="card-text"></p>').text('Member Id: ' + order.m_id));
											cardBody.append($('<p class="card-text"></p>').text('Date: ' + order.order_date));
											cardBody.append($('<p class="card-text"></p>').html('Status: <strong>' + order.status + '</strong>'));



											// Create the button
											let acceptButton = $('<button class="btn btn-success float-end" type="button">Accept</button>');

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
</div>

<%@ include file="footer.jsp"%>

<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/theme.js"></script>
</body>

</html>