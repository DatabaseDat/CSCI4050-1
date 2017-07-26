<!-- Code Modified from: https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_temp_store&stacked=h -->
<!-- Code modified from: https://colorlib.com/wp/html5-and-css3-login-forms/ -->
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<%@ page session="false" %>

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
	  <script src="./Scripts/loginRegister.js"></script>

	<!--  -->
		<script src="https://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>
 	 	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
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
		        <li class="active"><a href="#" onclick="document.forms['home'].submit()">Home</a></li>
		        <li><a href="#">Deals</a></li>
		        <li><a href="#">Contact</a></li>
		      </ul>
		      <c:choose>
    				<c:when test="${not empty name}">
					      <ul class="nav navbar-nav navbar-right">
					        <li><a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="caret"></span>  
					        	Hello, ${name} 
			
							<c:choose>
			    				<c:when test="${userType eq 2}">
										 <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
									      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">User Profile</a></li>
									      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Subscription Status</a></li>
									      <li role="presentation" class="divider"></li>    
									      <form form id="logoutForm" action="BookstoreServlet" method="post">
											  <input type="hidden" name="logout" value="logout">
									      	  <li role="presentation"><a role="menuitem" tabindex="-1" style="margin-left: 20px" "href="#" onclick="$(this).closest('form').submit()">Logout</a></li>
									      </form>
										  </ul>
										  
								</c:when>    
							    <c:otherwise>
							       <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
								      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Daily Report</a></li>
								      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Low Inventory Status</a></li>
								      <li role="presentation" class="divider"></li>    
								      <li role="presentation"><form id="logoutForm" action="BookstoreServlet" method="post">
											            		<button id="logoutButton" name="logout">Logout </button>
											          		  </form></li>
									  </ul>
							    </c:otherwise>
							</c:choose>
							
					        </a></li>
					        <li><a href="#" onclick="document.forms['displayCart'].submit()"><span class="glyphicon glyphicon-shopping-cart" ></span>Cart</a></li>
					      </ul>
					</c:when>
					<c:otherwise>
						<ul class="nav navbar-nav navbar-right">
				        <li><a href="#" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-user" data-toggle="modal" data-target="#myModal"></span>  
				        	Your Account 
				        	</a></li>
				        <li><a href="#" onclick="document.forms['displayCart'].submit()"><span class="glyphicon glyphicon-shopping-cart" ></span>Cart</a></li>
				      </ul>
					</c:otherwise>
				</c:choose>
		     
				    </div>
				  </div>
				  
				  <form action="CartServlet" name="displayCart" method="post">
				  	<input type="hidden" name="returnTo" value="index.jsp">
					<input type="hidden" name="displayCart" value="cart">
				  </form>
		    			
		    	 <form action="BookstoreServlet" name="home" method="post">
					<input type="hidden" name="home" value="home">
				 </form>
		  
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
						          
						        				<form action="BookstoreServlet" method="post">
						          
							         				<div class="top-row">
							            				<div class="field-wrap">
							              					<label>
							                					First Name<span class="req">*</span>
							              					</label>
							              					<input name="firstName" type="text" required autocomplete="off" />
							            				</div>
							        
							            				<div class="field-wrap">
							              					<label>
							                					Last Name<span class="req">*</span>
							              					</label>
							              					<input name="lastName" type="text"required autocomplete="off"/>
							            				</div>
							          				</div>
							
							          				<div class="field-wrap">
							            				<label>
							              					Username<span class="req">*</span>
							            				</label>
							            				<input name="username" type="text"required autocomplete="off"/>
							          				</div>
							          
							          				<div class="field-wrap">
							            				<label>
							              					Set A Password<span class="req">*</span>
							            				</label>
							            				<input name="password" type="password"required autocomplete="off"/>
							          				</div>
							          				
							          				<div class="field-wrap">
							            				<label>
							              					Email <span class="req">*</span>
							            				</label>
							            				<input name="email" type="text"required autocomplete="off"/>
							          				</div>
							          				<button class="button button-block" name="register">Get Started</button>
						          				</form>
						        			</div>
						        
							        		<div id="logintab">   
							          			<h1>Welcome Back!</h1>
							          
							        		  	<form id="loginForm" action="BookstoreServlet" method="post">
								            		<div class="field-wrap">
								            			<label>
								              				Username<span class="req">*</span>
								            			</label>
								            			<input type="text"required autocomplete="off" name="username"/>
								          			</div>
								          
								          			<div class="field-wrap">
								            			<label>
								              				Password<span class="req">*</span>
								            			</label>
								           				<input type="password"required autocomplete="off" name="password"/>
								          			</div>
								          				<p class="forgot"><a href="#">Forgot Password?</a></p>
								          				<button id="loginButton" class="button button-block" name="login">Log In </button>
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
		
		<div id="incorrectLogin">
			<c:if test="${not empty errorMsg}">
   				<script>
					window.addEventListener("load",function(){
						alert("${errorMsg}");
					});
				</script>
			</c:if>
		</div>
		
		<!-- BOOK ITEMS -->
 			<div data-role="page" >
	         	<div class="container">    
					<div class="row">			
						<c:forEach items="${books}" var="b">
							<div class="col-sm-4">
								<div class="panel panel-primary">
								<div class="panel-heading">${b.bookName}</div>
								<div class="panel-body"><img src="${b.CoverPhoto}" class="img-responsive" style="width:100%" alt="Image"></div>
								<div class="panel-footer">
									Author: ${b.author}
									<hr>
									Description: ${b.description}
									<hr>
									Price: $ ${b.price}
									<hr>
									<form action="BookHandlerServlet" name="bookHandler" method="post">
										<input type = "hidden" name="returnTo" value="index.jsp">
										<button type="submit" class="btn btn-primary btn-md" name="moreInfo" value="${b.ISBN}">View More Info</button>
										<button type="submit" class="btn btn-primary btn-md" name="add" value="${b.ISBN}">Add to Cart</button>
									</form>
								</div>
								</div>
							</div> 
	           			</c:forEach>
					</div>
				</div>
			</div>
			
		<br>
		<!-- FOOTER -->
		<footer class="container-fluid text-center">
		  <p>Online Store Copyright</p>  
		    <input type="email" class="form-control" size="50" placeholder="Email Address">
		    <button type="button" class="btn btn-danger">Sign Up</button>
		</footer>
	</body>
</html>
