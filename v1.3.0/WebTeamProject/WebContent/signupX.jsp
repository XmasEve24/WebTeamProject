<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
  	<title>회원가입</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css/signup_style.css">

	</head>
	<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section"></h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-7 col-lg-5">
					<div class="login-wrap p-4 p-md-5">
		      	<h3 class="text-center mb-4">Create Your Account</h3>
						<form action="signup.do" method="post" class="signup-form">
		      		<div class="form-group mb-3">
		      			<label class="label" for="name">Full Name</label>
		      			<input type="text" class="form-control" name="memberName" placeholder="Name">
		      		</div>
		      		<div class="form-group mb-3">
		      			<label class="label" for="email">Email Address</label>
		      			<input type="text" class="form-control" name="memberEmail" placeholder="Email">
		      		</div>
		      		<div class="form-group mb-3">
		      			<label class="label" for="id">ID</label>
		      			<input type="text" class="form-control" name="memberId" placeholder="ID">
		      		</div>
	            <div class="form-group mb-3">
	            	<label class="label" for="password">Password</label>
	              <input id="password-field" type="password" class="form-control" name="memberPw" placeholder="Password">
	              <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
	            </div>
	            <div class="form-group">
	            	<button type="submit" class="form-control btn btn-primary submit px-3">Sign Up</button>
	            </div>
	          </form>
	          <p>I'm already a member! <a href="login.jsp">Sign In</a></p>
	        </div>
				</div>
			</div>
		</div>
	</section>

	<script src="js/signup_js/jquery.min.js"></script>
  <script src="js/signup_js/popper.js"></script>
  <script src="js/signup_js/bootstrap.min.js"></script>
  <script src="js/signup_js/main.js"></script>

	</body>
</html>

