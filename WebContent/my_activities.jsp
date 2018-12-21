<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.js"></script>  
	<meta charset="ISO-8859-1">
	<title>My Activities</title>
</head>
<body>

	<div data-role="page" id="MyActivities">
	
	 <div data-role="header">
	 	<h1>My Activities</h1>
	 	<a href="" data-rel="back">back</a>
	 </div>
	 
	 <div data-role="content">
 		<ul data-role="listview" data-split-icon="gear" data-split-theme="d">
			<li>
				<img src="" />
				<h3>Back</h3>
				<p>sets:3, reps:8</p>
				<a href=""data-rel="dialog" data-transition="slideup">Edit Activity</a>
			</li>
			
			<li>
				<img src="" />
				<h3>Chest</h3>
				<p>sets:3, reps:10</p>
				<a href=""data-rel="dialog" data-transition="slideup">Edit Activity</a>
			</li>
			<li>
				<img src="" />
				<h3>Biceps</h3>
				<p>sets:4, reps:6</p>
				<a href=""data-rel="dialog" data-transition="slideup">Edit Activity</a>
			</li>
		</ul> 


	  </div>
	  <div data-role="footer" data-position="fixed">
			<center><a href="${pageContext.request.contextPath}/controller/UserController/index">Home Page</a></center>
	  </div>
	 </div>
 


</body>
</html>