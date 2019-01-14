<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="./add_activity_css.css"/>
	  
	<meta charset="ISO-8859-1">
	<title>Add new Activity</title>
</head>
<body>
	
	<div data-role="page" id="addActivity">
		 <div data-role="header">
	 		<a href="${pageContext.request.contextPath}/controller/UserController/getPage/home" data-role="button">Back</a>
		 	<h1>Add Activity</h1>
		 </div>
		 <div data-role="content">
			  	 <br>
 	 			 
 	 			 <center> Choose Your Activity</center>
			 	 
  			 	 
  			 	 <form action="${pageContext.request.contextPath}/controller/UserController/addActivity" method="post">
  			 	 
					<fieldset data-role="controlgroup" data-type="horizontal" style="width:100%">
					
					    <select name="activity_name" class="select_op" id="activity"">
					        <option value="#">Select Activity</option>
					        <option value="Back">Back</option>
					        <option value="Chest">Chest</option>
					        <option value="Shoulders">Shoulders</option>
					        <option value="Biceps">Biceps</option>
					        <option value="Triceps">Triceps</option>
					    </select>
					
					    <select name="sets" class="select_op" id="sets">
					        <option value="#">Select sets</option>
							<% for(int i=1; i<=10; i++)
							{ %>
					        <option value="<%=i%>"><%=i%></option>
							<%} %>
					    </select>
					
					    <select name="reps" class="select_op" id="reps">
					        <option value="#">Select reps</option>
							<% for(int i=1; i<=10; i++)
							{ %>
					        <option value="<%=i%>"><%=i%></option>
							<%} %>
					    </select>
					
					</fieldset>
					
		    		<button type="submit"> Add Activity</button>	
					
				</form>
  			 	 
 			 	 
		</div>
		<div data-role="footer" data-position="fixed">
		</div>
	 </div>
 
 
</body>
</html>