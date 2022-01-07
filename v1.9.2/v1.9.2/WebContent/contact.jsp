<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!DOCTYPE html>
<html lang="en">
<style>
select option[value=""][disabled] {
	display: none;
}
select:invalid{
	color: #a00;
}
</style>



<head>
<!--

Template 2082 Pure Mix

http://www.tooplate.com/view/2082-pure-mix

-->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="">
	<meta name="description" content="">

	<!-- Site title
   ================================================== -->
	<title>Pure Mix - Contact</title>

	<!-- Bootstrap CSS
   ================================================== -->
	<link rel="stylesheet" href="css/bootstrap.min.css">

	<!-- Animate CSS
   ================================================== -->
	<link rel="stylesheet" href="css/animate.min.css">

	<!-- Font Icons CSS
   ================================================== -->
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/ionicons.min.css">

	<!-- Main CSS
   ================================================== -->
	<link rel="stylesheet" href="css/style.css">

	<!-- Google web font 
   ================================================== -->	
  <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700,300' rel='stylesheet' type='text/css'>
	
</head>
<body>

<script>	
	function chooseType(){
		let type = document.getElementById('contactType').value;
		document.getElementById('portNum').disabled = "disable";
		document.getElementById('portNum').value = null;
		//console.log(type);
		//console.log(dis);
		if(type == "bug report"){
			document.getElementById('portNum').disabled = false;
			return true;
		}
		return false;
	}
</script>


<!-- Preloader section
================================================== -->
<div class="preloader">

	<div class="sk-spinner sk-spinner-pulse"></div>

</div>


<!-- Navigation section
================================================== -->
<div class="nav-container">
   <nav class="nav-inner transparent">

      <div class="navbar">
         <div class="container">
            <div class="row">

              <div class="brand">
                <a href="main.jsp">Pure Mix</a>
              </div>

              <div class="navicon">
              <div class="navicon">
               
               <mytag:login/>
              </div>
                <div class="menu-container">

                  <div class="circle dark inline">
                    <i class="icon ion-navicon"></i>
                  </div>

                  <div class="list-menu">
                    <i class="icon ion-close-round close-iframe"></i>
                    <div class="intro-inner">
                     	<ul id="nav-menu">
                       <li><a href="main.jsp">Home</a></li>
                        <li><a href="about.jsp">About</a></li>
                        <li><a href="board.jsp">Board</a></li>
                        <li><mytag:contact/></li>
                        <li><mytag:writePortfolio /></li>
                      </ul>
                    </div>
                  </div>

                </div>
              </div>

            </div>
         </div>
      </div>

   </nav>
</div>


<!-- Header section
================================================== -->
<section id="header" class="header-four">
	<div class="container">
		<div class="row">

			<div class="col-md-offset-3 col-md-6 col-sm-offset-2 col-sm-8">
            	<div class="header-thumb">
              		 <h1 class="wow fadeIn" data-wow-delay="0.6s">Contact Us</h1>
              		 <h3 class="wow fadeInUp" data-wow-delay="0.9s"></h3>
           		</div>
			</div>

		</div>
	</div>		
</section>


<!-- Contact section
================================================== -->
<section id="contact">
   <div class="container">
      <div class="row">

         <div class="wow fadeInUp col-md-6 col-sm-12" data-wow-delay="1.3s">
         	<div class="google_map">
				<div id="map-canvas"></div>
			</div>
		</div>

		<div class="wow fadeInUp col-md-6 col-sm-12" data-wow-delay="1.6s">
			<h1>Let's work together!</h1>
			<div class="contact-form">	
				<form id="contact-form" method="post" action="contact_insert.do">
					<select id="contactType" name="contactType" class="form-control" onchange='chooseType()' required>
						<option value="" disabled selected>Contact Type</option>
						<option value="inquiry">inquiry</option>
						<option value="communication">communication</option>
						<option value="bug report">bug report</option>
					</select>
						
					<select id="portNum" name="portNum" class="form-control">
						<option disabled selected>portNum</option>
						<c:forEach var="pn" items="${portSelectAll}">
							<option value="${pn.portNum}">${pn.portNum}</option>
						</c:forEach>
					</select>
<!-- 				<input name="portNum" type="number" class="form-control" placeholder="Portfolio Number" id="portNum" disabled="disabled">		 			
 -->				
			<!-- 로그인한 회원만 들어올 수 있으므로, 로그인정보에서 memberNum을 가져온다. -->
					<!-- <input name="memberName" type="text" class="form-control" placeholder="Your Name"> -->
					<input type="hidden" name="memberName" value="${memberName }">
					
					<input name="memberEmail" type="email" class="form-control" placeholder="Contact Email" required>
					<textarea name="contactContent" class="form-control" placeholder="Message" rows="4" required></textarea>
					
					<div class="contact-submit">
						<input type="submit" class="form-control submit" value="Send a message">
					</div>
				</form>
			</div>
		</div>

		<div class="clearfix"></div>

			<div class="col-md-4 col-sm-4">
				<div class="wow fadeInUp media" data-wow-delay="0.3s">
					<div class="media-object pull-left">
						<i class="fa fa-tablet"></i>
					</div>
					<div class="media-body">
						<h3 class="media-heading">Phone</h3>
						<p>+99 00 8877 6655</p>
					</div>
				</div>
			</div>

			<div class="col-md-4 col-sm-4">
				<div class="wow fadeInUp media" data-wow-delay="0.6s">
					<div class="media-object pull-left">
						<i class="fa fa-envelope"></i>
					</div>
					<div class="media-body">
						<h3 class="media-heading">Email</h3>
						<p>hello@company.com</p>
					</div>
				</div>
			</div>

			<div class="col-md-4 col-sm-4">
				<div class="wow fadeInUp media" data-wow-delay="0.9s">
					<div class="media-object pull-left">
						<i class="fa fa-globe"></i>
					</div>
					<div class="media-body">
						<h3 class="media-heading">Address</h3>
						<p>123 New Street, Old Town<br>
                        Another Village, 11220</p>
					</div>
				</div>
			</div>

      </div>
   </div>
</section>


<!-- Footer section
================================================== -->
<footer>
	<div class="container">
		<div class="row">

			<div class="col-md-12 col-sm-12">
				<p class="wow fadeInUp"  data-wow-delay="0.3s">Copyright © 2016 Your Company Name - Designed by Tooplate</p>
				<ul class="social-icon wow fadeInUp"  data-wow-delay="0.6s">
					<li><a href="#" class="fa fa-facebook"></a></li>
					<li><a href="#" class="fa fa-twitter"></a></li>
					<li><a href="#" class="fa fa-dribbble"></a></li>
					<li><a href="#" class="fa fa-behance"></a></li>
					<li><a href="#" class="fa fa-google-plus"></a></li>
				</ul>
			</div>
			
		</div>
	</div>
</footer>

<!-- Javascript 
================================================== -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/custom.js"></script>

</body>
</html>