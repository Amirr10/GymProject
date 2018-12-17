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
	
	<form action="">
	
	  <div class="container">
	    <label for="uemail"><b>E-mail</b></label>
	    <input type="text" id="email" placeholder="Enter E-mail" name="email" required>
	    <br>
	
	    <label for="upass"><b>Password</b></label>
	    <input type="password" placeholder="Enter Password" name="psw" required>
   	    <br>
	    
	    <label>
	      <input type="checkbox" checked="checked" name="remember"> Remember me
	    </label>
	  </div>
		
	  <div class="container">
  	    <button type="submit">Login</button>
	    <button type="button" >New User? Register Now</button>
	  </div>
	</form>
</body>
</html>