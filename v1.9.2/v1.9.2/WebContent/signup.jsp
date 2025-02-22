<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>    
<!DOCTYPE html>
<html lang="en">
<style>
.error_next_box {
    margin-top: 9px;
    font-size: 12px;
    color: red;    
    display: none;
}

</style>
<head>
	<title>Login Page</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
	<link rel="stylesheet" href="css/animate.min.css">
	
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-55">
				<form class="login100-form validate-form flex-sb flex-w" method="post" name="signup" action="signup.do">
					<span class="login100-form-title p-b-32">
						Create Your Account
					</span>

					<span class="txt1 p-b-11">
						ID
					</span>
					<div class="wrap-input100 validate-input m-b-36">
						<input class="input100" type="text" name="memberId" id="memberId">
						<span class="focus-input100"></span>
						<span class="error_next_box"></span>
					</div>
					<font name = "checkId" size = "2"></font>
					
					<span class="txt1 p-b-11">
						Email Address
					</span>
					<div class="wrap-input100 validate-input m-b-36" data-validate = "EmailAddress is required">
						<input class="input100" type="email" name="memberEmail" id="memberEmail">
						<span class="focus-input100"></span>
						<span class="error_next_box"></span>
					</div>
					
					<span class="txt1 p-b-11">
						Username
					</span>
					<div class="wrap-input100 validate-input m-b-36">
						<input class="input100" type="text" name="memberName" id="memberName">
						<span class="focus-input100"></span>
						<span class="error_next_box"></span>
					</div>
					
					<span class="txt1 p-b-11">
						Password
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate = "Password is required">
						<span class="btn-show-pass">
							<i class="fa fa-eye"></i>
						</span>
						<input class="input100" type="password" name="memberPw" id="memberPw" >
						<span class="focus-input100"></span>
						<span class="error_next_box"></span>
					</div>
					
					<span class="txt1 p-b-11">
						Password check
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate = "Password is required">
						<span class="btn-show-pass">
							<i class="fa fa-eye"></i>
						</span>
						<input class="input100" type="password" name="memberPwCheck" id="memberPwCheck"  >
						<span class="focus-input100"></span>

					</div>
						 <font name="check" size="2"></font>
					
					
					<div class="container-login100-form-btn">
					<br>
						<input type="button" class="login100-form-btn" onclick = "checkValue();" value="Sign up">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button class="login100-form-btn" onclick = "location.href = 'login.jsp' ">
							Login
						</button>
					</div>
					<br>
				</form>
			</div>
		</div>
	</div>


<script src = "js/jquery-3.6.0.min.js"></script>
<script>
	$('.input100').focusout(function(){
		let userId = $('.input100').val(); // input_id에 입력되는 값
		
		$.ajax({
			url : "login.do?memberId=${memberId}",
			type : "post",
			data : {userId: userId},
			dataType : 'json',
			success : function(result){
				if(result == 0){
					$("#checkId").html('사용할 수 없는 아이디입니다.');
					$("#checkId").attr('color','red');
				} else{
					$("#checkId").html('사용할 수 있는 아이디입니다.');
					$("#checkId").attr('color','green');
				} 
			},
			error : function(){
				alert("서버요청실패");
			}
		})
		 
	})
 </script>
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="js/jquery_pw.js"></script>
	<script src="js/signup.js"></script>
	<script src="js/idCheck.js"></script>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src = "js/jquery-3.6.0.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>
<script src = "js/jquery-3.6.0.min.js"></script>
</body>
</html>