<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="./css/indexCSS.css">
	<%@ page import="com.hit.model.*, java.util.*" %>
	<% 
		String user_name = "User";
		User user = (User)session.getAttribute("user"); 
		if(user!=null) 
			user_name = user.getFirstName();
	%>
</head>
<body>
	<h3> Hi, <%=user_name%></h3>
	
	<ul>
		<li> My Activities </li>
		<li> Reports</li>
	</ul>
	
</body>
</html>