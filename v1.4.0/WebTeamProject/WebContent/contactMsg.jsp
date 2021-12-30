<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>    
<!doctype html>
<html lang="en">
  <head>
  	<title>ContactMsg</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css/contactMsg_style.css">

	</head>
	<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-4">
					<h2 class="heading-section">Contact</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h3 class="h5 mb-4 text-center">ContactMsg</h3>
					<div class="table-wrap">
						<table class="table myaccordion table-hover" id="accordion">
						  <thead>
						    <tr>
						      <th>No</th>
						      <th>Email</th>
						      <th>문의 유형</th>
						      <th>PortfolioNumber</th>
						      <th>MemeberNumber</th>
						      <th>&nbsp;</th>
						    </tr>
						  </thead>
						  <tbody>
						      <c:forEach var="c" items="${contactData}">
						    <tr data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
						      <th scope="row">${c.contactNum}</th>
						 	  	<td><c:out value="${c.portNum}"/></td>
							   <td><c:out value="${c.memberEmail}"/></td>
							   <td><c:out value="${c.contactType}"/></td>
							   <td><c:out value="${c.memberName}"/></td>
						      <td>
						      	<i class="fa" aria-hidden="true"></i>
				        	</td>
						    </tr>
						    <tr>
						    	<td colspan="6" id="collapseOne" class="collapse show acc" data-parent="#accordion">
						    		<p>${c.contactContent}</p>
						    	</td>
						    </tr>
							</c:forEach>
						   <!-- <tr data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo" class="collapsed">
						      <th scope="row">2</th>
						      <td>Laptop Technology AS2020</td>
						      <td>$200.00</td>
						      <td>2</td>
						      <td>$400.00</td>
						      <td>
						      	<i class="fa" aria-hidden="false"></i>
				        	</td>
						    </tr>
								<tr>
						    	<td colspan="6" id="collapseTwo" class="collapse acc" data-parent="#accordion">
						    		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Porro iste, facere sunt sequi nostrum ipsa, amet doloremque magnam reiciendis tempore sapiente. Necessitatibus recusandae harum nam sit perferendis quia inventore natus.</p>
						    	</td>
						    </tr> -->

					
						  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="js/contactMsg_js/jquery.min.js"></script>
  <script src="js/contactMsg_js/popper.js"></script>
  <script src="js/contactMsg_js/bootstrap.min.js"></script>
  <script src="js/contactMsg_js/main.js"></script>

	</body>
</html>

