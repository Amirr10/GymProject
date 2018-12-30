<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Activity</title>
</head>
<body>
	<%@ page import="com.hit.model.*, java.util.*" %>

	<%
	User user = (User) session.getAttribute("user");
	Activity activity = (Activity) request.getAttribute("activity");
	
	%>
	
	<div data-role="page" id="home">
		 <div data-role="header">
		 <h1>Edit Activity </h1>
		 </div>
		 <div data-role="content">
		
		<center><h3> <%=activity.getWorkoutName() %></h3></center>
		<form action="${pageContext.request.contextPath}/controller/UserController/editOrRemove/<%=activity.getActivityId()%>" method="post">
			<table>
				<tr>
			    	<td>Reps:</td>
			    	<td>
			    		<input type="text" id="reps" value="<%=activity.getNumRep() %>" name="reps" >
		    		</td>
		   		</tr>
				
				<tr>	
			    	<td>Sets:</td>
			    	<td>
			    		<input type="text" id="sets" value="<%=activity.getNumSets() %>" name="sets" >
		    		</td>
		   		</tr>
		   		
	
				<tr>
					<td>
		  	    		<button type="submit" value="UPDATE" name="kb" >Update</button>
		    		</td>
		    		
		    		<td>
			    		<button type="submit" value="DELETE" name="kb" >Delete</button>	
		    		</td>
			    </tr>
			  </table>
		</form>			
		 </div>

	 </div>
	 

</body>
</html>