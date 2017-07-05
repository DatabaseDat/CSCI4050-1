<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="./CSS/custom.css">
  <link rel="stylesheet" href="./CSS/animate.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="./JS/script.js"></script>
</head>
<body>

<div id="mySidenav" class="sidenav">
  <!-- <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a> -->
<div id="x">
  <div class="outer">
  <div class="inner" onclick="closeNav()">
    <label>close</label>
  </div>
</div>
</div>
<br><br><br>
<form id="login" action="login">
<br>
  <t>Username:<br>
  <input type="text" name="username" autocomplete="on">
  <br>
  <br>
  Password:<br>
  <input type="password" name="password" id="password" maxlength="6">
  <br><br>
  <input type="submit" value="Submit">
</form>
 <br>
</div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Borders</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Books</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <img id="logo" src="./Images/logo.png" class="animated swing" height="55" width="55"> <!--Fun Logo if have time or bored -->
    <div class="dropdown">  <button type="button" class="dropbtn">
          <span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart
        </button>
        <div class = "dropdown-content"> <!-- Maybe use a BS Popover instead -->
          Fill with content
        </div>
      </div>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; Login</span></a></li>

      </ul>
    </div>
  </div>
</nav>



<div class="jumbotron">
  <div class="container text-center">
      <div class="container">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="./Images/Book1.jpg" class="img-thumbnail" alt="Los Angeles" style="width:100%;">
      </div>

      <div class="item">
        <img src="./Images/Book2.jpg" class="img-thumbnail" alt="Chicago" style="width:100%;">
      </div>

      <div class="item">
        <img src="./Images/Book3.jpg" class="img-thumbnail" alt="New york" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>


  </div>
</div>

<div id="searches"> <!--Megan Note: Maybe change this -->
 <form class="form-inline" action="/action_page.php">
    <div class="form-group">
      <input type="text" class="form-control" id="authorSearch" placeholder="Search By Author...." name="author">
    </div>
    <div class="form-group">
      <input type="text" class="form-control" id="titleSearch" placeholder="Search By Title" name="title">
    </div>
    <div class="form-group">
      <input type="text" class="form-control" id="catSearch" placeholder="Search By Category" name="category">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

<br>


<div id="books">
<div class="container-fluid bg-3 text-center">
  <div class="row">
    <div class="col-sm-3">
      <p>Some text..</p>
      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" data-toggle="modal" data-target="#myModal" style="width:100%" alt="Image">
    	<!-- Modal -->
  		<div class="modal fade" id="myModal" role="dialog">
    	<div class="modal-dialog">

      	<!-- Modal content-->
      	<div class="modal-content">
        	<div class="modal-header">
          	<button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>

    </div>
    </div>
    </div>

    <div class="col-sm-3">
      <p>Some text..</p>
      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" data-toggle="modal" data-target="#myModal" style="width:100%" alt="Image">
    	<!-- Modal -->
  		<div class="modal fade" id="myModal" role="dialog">
    	<div class="modal-dialog">

      	<!-- Modal content-->
      	<div class="modal-content">
        	<div class="modal-header">
          	<button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>

    </div>
    </div>
    </div>

    <div class="col-sm-3">
      <p>Some text..</p>
      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" data-toggle="modal" data-target="#myModal" style="width:100%" alt="Image">
    	<!-- Modal -->
  		<div class="modal fade" id="myModal" role="dialog">
    	<div class="modal-dialog">

      	<!-- Modal content-->
      	<div class="modal-content">
        	<div class="modal-header">
          	<button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>

    </div>
    </div>
    </div>


    <div class="col-sm-3">
      <p>Some text..</p>
      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" data-toggle="modal" data-target="#myModal" style="width:100%" alt="Image">
    	<!-- Modal -->
  		<div class="modal fade" id="myModal" role="dialog">
    	<div class="modal-dialog">

      	<!-- Modal content-->
      	<div class="modal-content">
        	<div class="modal-header">
          	<button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
    <div class="col-sm-3">
      <p>Some text..</p>
      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3">
      <p>Some text..</p>
      <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" data-toggle="modal" data-target="#myModal" style="width:100%" alt="Image">
    	<!-- Modal -->
  		<div class="modal fade" id="myModal" role="dialog">
    	<div class="modal-dialog">

      	<!-- Modal content-->
      	<div class="modal-content">
        	<div class="modal-header">
          	<button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</div><br><br>
</div>
</div>
</div>
</div>
</div>
<br>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>
