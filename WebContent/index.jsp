<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.css" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.js">
	
</script>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="./css/indexCSS.css"> 

</head>
<body>

<div data-role="page" id="home">
 <div data-role="header">
 <h1>Hello <%String str = request.getParameter("name"); %>
	 <% out.print(str); %></h1>
 </div>
 <div data-role="content">
 <center> 
  </br></br></br>


			 <a href="addActivity.jsp">Add New Activity</a> </br>
		</br><a href="MyActivities.jsp">My Activities</a></br>
		</br><a href="Reports.jsp">Reports</a> </br>
		

	
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