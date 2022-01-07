<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE html>
<html lang="en">
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
<title>About Page</title>

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
<link
	href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700,300'
	rel='stylesheet' type='text/css'>

</head>
<body>


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

								<mytag:login />
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
											<li><mytag:contact /></li>
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
	<section id="header" class="header-three">
		<div class="container">
			<div class="row">

				<div class="col-md-offset-3 col-md-6 col-sm-offset-2 col-sm-8">
					<div class="header-thumb">
						<h1 class="wow fadeIn" data-wow-delay="0.6s">About Us</h1>
						<h3 class="wow fadeInUp" data-wow-delay="0.9s"></h3>
					</div>
				</div>

			</div>
		</div>
	</section>


	<!-- About section
================================================== -->
	<section id="about">
		<div class="container">
			<div class="row">

				<div class="wow fadeInUp col-md-4 col-sm-5" data-wow-delay="1.3s">
					<img src="images/about-img1.jpg" class="img-responsive" alt="About">
				</div>

				<div class="wow fadeInUp col-md-7 col-sm-7" data-wow-delay="1.6s">
					<h1>개요</h1>
					<p>
					저희 조는 사이트 이용자들이 자유롭게 이용하고 댓글을 사용해 소통할 수 있는 사이트를 만들었습니다. 
					사이트를 이용하는 유저들은 여러가지 포트폴리오를 볼 수있고 포트폴리오마다 코멘트를 달아서 소통할 수 있으며
					문제가 발생하거나 궁금한점등이 있다면 contact를 이용하여 문의사항이나 질문, 버그리포트등을 문의할 수 있습니다.
					</p>
					<br><br><br>
					<h1>발전방향</h1>
					<p>지금은 관리자밖에 포트폴리오를 올릴 수 없지만 추후에 일반유저들도 자유롭게 포트폴리오를 올릴수 있도록
						변경하고, 추천이나 좋아요등을 추가해 메인페이지에 있는 isotope를 사용해 추천을 많이 받은 포트폴리오나 포트폴리오
						종류등을 나누어 정렬이되게 하려고 합니다.</p>
				</div>
				<div class="clearfix"></div>

				<div class="wow fadeInUp col-md-6 col-sm-6" data-wow-delay="1.3s">
					<h1>Development environment</h1>
					<p>
					개발환경 : Eclipse, vscode, Tomcat <br>
					사용언어 : JAVA, HTML, CSS, JavaScript, JSP, Ajax, jQuery, EL & JSTL <br>
					버전관리 : GitHub <br>
					데이터베이스 : mysql</p>
				</div>
				<div class="wow fadeInUp col-md-6 col-sm-6" data-wow-delay="1.3s">
					<h1>역할 분담</h1>
					<p>
					Model - <br>
					View - ko byung hyun<br>
					Controller - 
					</p>
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
					<p class="wow fadeInUp" data-wow-delay="0.3s">Copyright © 2016
						Your Company Name - Designed by Tooplate</p>
					<ul class="social-icon wow fadeInUp" data-wow-delay="0.6s">
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