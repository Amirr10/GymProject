<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.js"></script>
	<meta charset="UTF-8">
	<title>Login</title>
</head>
<body>
	<div data-role="page" id="login">
	
		<h3> Welcome to GymTracker</h3>
		
		<form action="${pageContext.request.contextPath}/controller/LoginController/login" method="post">
			<table>
			<tr>
		    	<td>E-mail:</td>
		    	<td>
		    		<input type="text" id="email" placeholder="Enter E-mail" name="email" >
	    		</td>
	   		</tr>
			
			<tr>	
		    	<td>Password:</td>
		    	<td>
		    		<input type="password" placeholder="Enter Password" name="psw" >
	    		</td>
	   		</tr>
	   		

			<tr>
				<td>
	  	    		<button type="submit" value="LOGIN" name="kb" >Login</button>
	    		</td>
	    		
	    		<td>
		    		<button type="submit" value="REGISTER" name="kb" >New User? Register Now</button>	
	    		</td>
		    </tr>
		  </table>
		</form>
	</div>
</body>
</html>