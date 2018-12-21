<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	<meta charset="UTF-8">
	<title>Home</title>
	
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
		
		
					 <a href="${pageContext.request.contextPath}/controller/UserController/getPage/addActivity" data-role="button">Add New Activity</a> </br>
				</br><a href="${pageContext.request.contextPath}/controller/UserController/getPage/myActivities" data-role="button">My Activities</a></br>
				</br><a href="${pageContext.request.contextPath}/controller/UserController/getPage/myReports" data-role="button">Reports</a> </br>
				
			
		 </div>
		 <div data-role="footer" data-position="fixed">
		<h4><a href="${pageContext.request.contextPath}/controller/UserController/logout" data-role="button">Logout</a></h4>
		 </div>
	 </div>
	 

  </body>
</html>