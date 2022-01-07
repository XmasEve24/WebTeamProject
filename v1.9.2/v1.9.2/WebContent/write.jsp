<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Page</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="">
	<meta name="description" content="">

	<!-- Site title
   ================================================== -->
	<title>Pure Mix - Single Post</title>

	<!-- Bootstrap CSS
   ================================================== -->
	<link rel="stylesheet" href="css/bootstrap.min.css">

	<!-- Animate CSS
   ================================================== -->
<!-- 	<link rel="stylesheet" href="css/animate.min.css"> -->

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
<section id="single-post">
   <div class="container">
      <div class="row">

         <div class="wow fadeInUp col-md-offset-1 col-md-10 col-sm-offset-1 col-sm-10" data-wow-delay="2.3s">
         	  <div class="blog-thumb">
         		   
         		   <h1>portfolio</h1>
               

               <div class="blog-comment-form">
                  <h3>Leave a portfolio</h3>
                    <form action="portfolioWrite.do" method="post">
                    <input type="hidden" name="adminNum" value="${adminNum }">
                    <input type="hidden" name="adminName" value="${adminName }">
                      <!-- 날짜 -->
                      <input type="text" class="form-control" placeholder="Title" name="portTitle" required>
                      <textarea class="form-control" placeholder="Content" rows="5"  name="portContent" required ></textarea>
                    
                      <div class="contact-submit">
                      <!-- 그림 파일 삽입 -->
                      <!-- <input type="file" id="chooseFile" name="chooseFile" accept="image/*" onchange="loadFile(this)">  -->
                      	<input name="submit" type="submit" class="form-control" id="submit" value="Submit a portfolio">
                      </div>
                   </form>
               </div>
         	  </div>
		    </div>

      </div>
   </div>
</section>
	
	
	<!-- Javascript 
================================================== -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/custom.js"></script>
</body>
</html>