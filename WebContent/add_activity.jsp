<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.js"></script>  
	<meta charset="ISO-8859-1">
	<title>Add new Activity</title>
</head>
<body>
	
	<div data-role="page" id="addActivity">
		 <div data-role="header">
		 	<h1>Add Activity</h1>
		 	<a href="" data-rel="back">back</a>
		 </div>
		 <div data-role="content">
			  	 <br>
 	 			 
 	 			 <center> Choose Your Activity</center>
			 	 
				 </br>
			 	 <a href="${pageContext.request.contextPath}/controller/UserController/addActivity/back" data-role="button">Chest</a>
			 	 <a href="${pageContext.request.contextPath}/controller/UserController/index" data-role="button">Back</a>
			 	 <a href="${pageContext.request.contextPath}/controller/UserController/index" data-role="button">Shoulders</a>
 			 	 <a href="${pageContext.request.contextPath}/controller/UserController/index" data-role="button">Shoulders</a>
  			 	 <a href="${pageContext.request.contextPath}/controller/UserController/index" data-role="button">Biceps</a>
  			 	 <a href="${pageContext.request.contextPath}/controller/UserController/index" data-role="button">Triceps</a>
  			 	 
 			 	 
		</div>
		<div data-role="footer" data-position="fixed">
			<center><a href="${pageContext.request.contextPath}/controller/UserController/index">Home Page</a></center>
		</div>
	 </div>
 
 
</body>
</html>