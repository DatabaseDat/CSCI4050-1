<!DOCTYPE html>
<html lang="en">
	<head>
	  <title>Bookstore</title>
	  <!-- Bootstrap -->
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  
	  <!-- Ours -->
	  <link rel="stylesheet" href="./CSS/ecommerceTemplate.css">
	  <link rel="stylesheet" href="./CSS/loginRegister.css">
	  <link rel="stylesheet" href="./CSS/cart.css">
	</head>
	<body>
		<!-- HEADER -->
		<div class="jumbotron">
		  <div class="container text-center">
		    <h1>Welcome to the Bookstore</h1>
		  </div>
		</div>
		
		<!-- NAV BAR -->
		<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>                        
		      </button>
		      <a class="navbar-brand" href="#">Logo</a>
		    </div>
		    <div class="collapse navbar-collapse" id="myNavbar">
		      <ul class="nav navbar-nav">
		        <li class="active"><a href="#">Home</a></li>
		        <li><a href="#">Deals</a></li>
		        <li><a href="#">Contact</a></li>
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="#" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-user" data-toggle="modal" data-target="#myModal"></span> Your Account</a></li>
		        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
		      </ul>
		    </div>
		  </div>
		  
		  <!-- Modal -->
		  <div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog">
		      <!-- Modal content-->
		          <!-- LOGIN/REGISTER -->
						<button type="button" id="modalButton" class="btn btn-default" data-dismiss="modal">X</button>
						<div class="form">
					    	<ul class="tab-group">
			        			<li class="tab active"><a href="#signup">Sign Up</a></li>
			        			<li class="tab"><a href="#logintab">Log In</a></li>
			      		  	</ul>
			      
			      			<div class="tab-content">
			        			<div id="signup">   
			          				<h1>Sign Up for Free</h1>
			          
			        				<form action="/" method="post">
			          
				         				<div class="top-row">
				            				<div class="field-wrap">
				              					<label>
				                					First Name<span class="req">*</span>
				              					</label>
				              					<input type="text" required autocomplete="off" />
				            				</div>
				        
				            				<div class="field-wrap">
				              					<label>
				                					Last Name<span class="req">*</span>
				              					</label>
				              					<input type="text"required autocomplete="off"/>
				            				</div>
				          				</div>
				
				          				<div class="field-wrap">
				            				<label>
				              					Email Address<span class="req">*</span>
				            				</label>
				            				<input type="email"required autocomplete="off"/>
				          				</div>
				          
				          				<div class="field-wrap">
				            				<label>
				              					Set A Password<span class="req">*</span>
				            				</label>
				            				<input type="password"required autocomplete="off"/>
				          				</div>
				          
				          				<button type="submit" class="button button-block">Get Started</button>
			          				</form>
			        			</div>
			        
				        		<div id="logintab">   
				          			<h1>Welcome Back!</h1>
				          
				        		  	<form action="/" method="post">
					            		<div class="field-wrap">
					            			<label>
					              				Email Address<span class="req">*</span>
					            			</label>
					            			<input type="email"required autocomplete="off"/>
					          			</div>
					          
					          			<div class="field-wrap">
					            			<label>
					              				Password<span class="req">*</span>
					            			</label>
					           				<input type="password"required autocomplete="off"/>
					          			</div>
					          				<p class="forgot"><a href="#">Forgot Password?</a></p>
					          				<button class="button button-block">Log In </button>
					          		</form>
						        </div>
			      			</div>
			 			<br>
			 			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
						<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
						<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
						<script src="./Scripts/loginRegister.js"></script>
						</div>
					</div> <!-- end login/register form -->
		        </div>
		</nav>
		
		
		<div class="container" style="width: 90%">
			<div class="row">
				<div class="col-xs-8" style="width: 90%">
					<div class="panel panel-info">
						<div style="background-color: #121E24;" class="panel-heading">
							<div class="panel-title">
								<div class="row">
									<div style="background-color: #121E24;" class="col-xs-6">
										<h5 style="background-color: #121E24; color: white;"><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</h5>
									</div>
									<div class="col-xs-6">
										<button type="button" id="continueButton" class="btn btn-primary btn-sm btn-block">
											<span class="glyphicon glyphicon-share-alt"></span> Continue shopping
										</button>
									</div>
								</div>
							</div>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-xs-2"><img class="img-responsive" src="./Resources/cover4.jpg">
								</div>
								<div class="col-xs-4">
									<h4 class="product-name"><strong>Lord of the Rings</strong></h4><h4><small></small></h4>
								</div>
								<div class="col-xs-6">
									<div class="col-xs-6 text-right">
										<h6><strong>15.00 <span class="text-muted">x</span></strong></h6>
									</div>
									<div class="col-xs-4">
										<input type="text" class="form-control input-sm" value="1">
									</div>
									<div class="col-xs-2">
										<button type="button" class="btn btn-link btn-xs">
										<span class="glyphicon glyphicon-trash"> </span>
										</button>
									</div>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-xs-2"><img class="img-responsive" src="./Resources/cover2.jpg">
								</div>
								<div class="col-xs-4">
									<h4 class="product-name"><strong>Software Engineering</strong></h4><h4><small></small></h4>
								</div>
								<div class="col-xs-6">
									<div class="col-xs-6 text-right">
										<h6><strong>55.00 <span class="text-muted">x</span></strong></h6>
									</div>
									<div class="col-xs-4">
										<input type="text" class="form-control input-sm" value="1">
									</div>
									<div class="col-xs-2">
										<button type="button" class="btn btn-link btn-xs">
											<span class="glyphicon glyphicon-trash"> </span>
										</button>
									</div>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="text-center">
									<div class="col-xs-9">
										<h6 class="text-right">Added items?</h6>
									</div>
									<div class="col-xs-3">
										<button type="button" id="updateButton" class="btn btn-primary btn-sm btn-block">
											<span class="glyphicon glyphicon-share-alt"></span> Update Cart
										</button>
									</div>
								</div>
							</div>
						</div>
						<div class="panel-footer">
							<div class="row text-center">
								<div class="col-xs-9">
									<h4 class="text-right">Total <strong>$70.00</strong></h4>
								</div>
								<div class="col-xs-3">
									<button type="button" id="checkoutButton" class="btn btn-primary btn-sm btn-block">
											<span class="glyphicon glyphicon-share-alt"></span> Checkout
										</button>
  								</div>
  							</div>
						</div> 
					</div>
				</div>
			</div>
		</div>
		
		<!-- FOOTER -->
		<footer class="container-fluid text-center">
		  <p>Online Store Copyright</p>  
		    <input type="email" class="form-control" size="50" placeholder="Email Address">
		    <button type="button" class="btn btn-danger">Sign Up</button>
		</footer>
	</body>
</html>