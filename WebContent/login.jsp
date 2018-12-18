<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/loginCSS.css">
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<h3> Welcome to GymTracker</h3>
	
	<form action="controller/LoginController/login" method="post">
		<table>
		<tr>
	    	<td>E-mail:</td>
	    	<td>
	    		<input type="text" id="email" placeholder="Enter E-mail" name="email" required>
    		</td>
   		</tr>
		
		<tr>	
	    	<td>Password:</td>
	    	<td>
	    		<input type="password" placeholder="Enter Password" name="psw" required>
    		</td>
   		</tr>
   		
   		<tr>
   			<td></td>
   			<td>
	      		<input type="checkbox" checked="checked" name="remember"> Remember me
	      	</td>
	      
	    </tr>
		<tr>
			<td>
  	    		<button type="submit" value="LOGIN" >Login</button>
    		</td>
    		
    		<td>
	    		<button type="button" >New User? Register Now</button>	
    		</td>
	    </tr>
	  </table>
	</form>
</body>
</html>