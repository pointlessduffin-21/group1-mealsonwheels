<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Donator Dashboard</title>
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
											<div style="height: 65px; width: 65px;" class="rounded bg-primary">
						                        <div class="h-100 fs-1 text-white d-flex justify-content-center" style="width: 65px;">
						                            <span style="font-size: 0.8em;" class="my-auto">H</span>
						                            <span style="font-size: 0.8em;" class="my-auto">G</span>
						                        </div>
						                    </div>
										</div>
										<div class="col me-2 ps-3">
											<div class="text-uppercase text-secondary fw-bold text-xs mb-1 fs-5">
												<span>Hermione Granger</span>
											</div>
											<span>Donator</span>
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
											<div>
												<span>You've Donated:</span>
												<span class="text-uppercase text-secondary fw-bold text-xs mb-1 fs-5 pe-3">$100,209</span>
											</div>
											<div>
												<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#donateModal">
												  DONATE
												</button>
												
												<!-- Modal -->
												<div class="modal fade" id="donateModal" tabindex="-1" aria-labelledby="donateModalLabel" aria-hidden="true">
												  <div class="modal-dialog">
												    <div class="modal-content">
												      <div class="modal-header">
												        <h1 class="modal-title fs-5" id="donateModalLabel">Donate</h1>
												        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
												      </div>
												      <div class="modal-body">
															<form class='m-2' action="/register_user" method="post">

													            <div class='form-group mb-3 text-center'>
													                <label htmlFor='address'>Amount</label>
													                <input
													                        type='text'
													                        class='form-control'
													                        id='address'
													                        name='address'
													                />
													            </div>
																<button type="submit" class="btn btn-primary col-12">Save changes</button>
													        </form>
												      </div>
												      <div class="modal-footer">
												        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
												        
												      </div>
												    </div>
												  </div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-4 col-xxl-4 mb-4">
								<div class="card shadow mb-4"></div>
								<div class="card shadow mb-4">
								    <div class="card-header py-3">
										<h6 class="text-secondary fw-bold m-0"
											style="color: rgb(45, 237, 42);">Notification</h6>
									</div>
								     <div>
					                    <div class="alert alert-info"><span class="fw-bold">Jhon Doe</span> donated <span class="fw-bold">1,000,000</span> on <span class="fw-bold">June 18, 2023</span></div>
					                    <!-- Add more notifications here -->
					                </div>
								</div>
							</div>
							<div class="col-lg-8 col-xxl-8 mb-4">
								<div class="card shadow mb-4"></div>
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="text-secondary fw-bold m-0"
											style="color: rgb(45, 237, 42);">Your Donations</h6>
									</div>
									<div class="card-body">
								      <div class="table-responsive">
								        <table class="table table-bordered" id="donationsTable">
								          <thead>
								            <tr>
								              <th>#</th>
								              <th>Date</th>
								              <th>Amount</th>
								            </tr>
								          </thead>
								          <tbody>
								            <tr>
								              <td>1</td>
								              <td>January 17, 2023</td>
								              <td>$100</td>
								            </tr>
								            <tr>
								              <td>2</td>
								              <td>January 2, 2023</td>
								              <td>$50</td>
								            </tr>
								         	<tr>
								              <td>3</td>
								              <td>December 12, 2022</td>
								              <td>$500</td>
								            </tr>
								          </tbody>
								        </table>
								      </div>
								    </div>
								</div>
							</div>
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