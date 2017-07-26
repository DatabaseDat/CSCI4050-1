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
		        <li class="active"><a href="#" onclick="document.forms['home'].submit()">Home</a></li>
		        <li><a href="#">Deals</a></li>
		        <li><a href="#">Contact</a></li>
		      </ul>

	
			  </div>
			</div>
				  
				  <form action="CartServlet" name="displayCart" method="post">
					<input type="hidden" name="displayCart" value="cart">
				  </form>
				  
				   <form action="BookstoreServlet" name="home" method="post">
				 		<input type="hidden" name="home" value="home">
				  	</form>
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
									</div>
								</div>
							</div>
						</div>
						<div class="panel-body">
						
						<c:forEach items="${booksInCart}" var="b">
							<div class="row">
								<div class="col-xs-2"><img class="img-responsive" src="https://placehold.it/150x80?text=IMAGE">
								</div>
								<div class="col-xs-4">
									<h4 class="product-name"><strong>${b.bookName}</strong></h4><h4><small></small></h4>
								</div>
								<div class="col-xs-6">
									<div class="col-xs-6 text-right">
										<h6><strong>$ ${b.price} <span class="text-muted">x</span></strong></h6>
									</div>
									<div class="col-xs-4">
										<input type="text" class="form-control input-sm" value="${b.quantity}">
									</div>
									<div class="col-xs-2">
									  <form action="CartServlet" name="deleteItem" value="delete">
									  	<input type="hidden" name="bookToDelete" value="${b.ISBN}">
										<button type="submit" class="btn btn-link btn-xs">
											<span class="glyphicon glyphicon-trash"> </span>
										</button>
									  </form>
									</div>
								</div>
							</div>
							<hr>
						</c:forEach>
							
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
									<h4 class="text-right">Total <strong>$ ${total}</strong></h4>
								</div>
								<div class="col-xs-3">
								<form action="CheckoutServlet" name="checkout" method="post">
									<button type="submit" id="checkoutButton" class="btn btn-primary btn-sm btn-block" name="checkout" value="checkout">
											<span class="glyphicon glyphicon-share-alt"></span> Checkout
										</button>
								</form>
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