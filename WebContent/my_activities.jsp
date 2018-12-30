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
<%@ page import="com.hit.model.*, java.util.*" %>
<%
	List<Activity> mActivities = (List) request.getAttribute("activities");
/* 	Collections.sort(mActivities, new Comparator<Activity>() {
    @Override
    public int compare(Activity a1, Activity a2) {
        // TODO Auto-generated method stub
        return a1.getDate_created().compareTo(a2.getDate_created());
    	}
	}); */
%>

	<div data-role="page" id="MyActivities">
	
	 <div data-role="header">
	 	<h1>My Activities</h1>
	 	<a href="${pageContext.request.contextPath}/controller/UserController/getPage/home" data-rel="back">Back</a>
	 </div>
	 
	 <div data-role="content">
 		<ul data-role="listview" data-split-icon="gear" data-split-theme="d">
  		<%
 		if(mActivities.isEmpty())
 		{
 		
 			out.print("<h3>You don't have any activities right now.</h3>");
 		
	  	} else {
 	 		for (Activity activity : mActivities)
	 		{
	 	%>
	 			<li> 
	 			<br>					
		
					<a href="${pageContext.request.contextPath}/controller/UserController/editActivity/<%=activity.getActivityId()%>" data-rel="dialog" data-transition="slideup">
					<h3><%=activity.getWorkoutName() %> </h3>
					<br>
					<p>Sets: <%=activity.getNumSets() %> , Reps: <%=activity.getNumRep() %></p>
					</a>								
				</li>
		<%
	 		}
	  	}
		
 		%>

		</ul> 


	  </div>
	  <div data-role="footer" data-position="fixed">
			<center><a href="${pageContext.request.contextPath}/controller/UserController/index">Home Page</a></center>
	  </div>
	 </div>
 


</body>
</html>