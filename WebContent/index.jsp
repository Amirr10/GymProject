<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
<!-- /	<link rel="stylesheet" type="text/css" href="./css/indexCSS.css">
 -->	
 	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.js"></script>
	
	<%@ page import="com.hit.model.*, java.util.*" %>
	<% 
		String user_name = "User";
		User user = (User)session.getAttribute("user"); 
		if(user!=null) 
			user_name = user.getFirstName();
		else
			response.sendRedirect("controller");
	%>
</head>
	<body>
	
	<div data-role="page" id="home">
		 <div data-role="header">
		 <h1>Hello <%=user_name %>
		 </div>
		 <div data-role="content">
		 <center> 
		  </br></br></br>
		
		
					 <a href="controller/UserController/addActivity">Add New Activity</a> </br>
				</br><a href="controller/UserController/myActivities">My Activities</a></br>
				</br><a href="controller/UserController/myReports">Reports</a> </br>
				
		
			
		 </center>
		 </div>
		 </br></br>
		 <div data-role="footer" data-position="fixed">
		<h4><a href="index.jsp">Home</a></h4>
		 </div>
	 </div>
	 
	 <!--  
	<center>
	<%//String str = request.getParameter("name"); %>
		<h3>Hi, <%// out.print(str); %> </h3> </center>
		 
		<ul>
	
			<li><a href="addActivity.jsp">Add New Activity</a></li></br>
			<li><a href="MyActivities.jsp">My Activities</a></li></br>
			<li><a href="Reports.jsp">Reports</a></li></br>
			<h3></h3>
	
		</ul>
	-->
	</body>
</html>