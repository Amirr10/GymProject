<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>

	<h3> Create a new user</h3>

	<form action="">
	
	  <div class="container">
	    <label for="umail"><b>E-mail</b></label>
	    <input type="text" id="email" placeholder="Enter E-mail" name="email" required>
	    <br>
	    
   	    <label for="uname"><b>Username</b></label>
	    <input type="text" id="username" placeholder="Enter Username" name="username" required>
	    <br>
	
	    <label for="psw"><b>Password</b></label>
	    <input type="password" placeholder="Enter Password" name="psw" required>
   	    <br>
   	    
  	    <label for="rpsw"><b>re-password</b></label>
	    <input type="password" placeholder="Re-Enter Password" name="rpsw" required>
   	    <br>
	    
	  </div>
		
	  <div class="container">
   	    <button type="submit">Back</button>
  	    <button type="submit">Sign Up</button>
	  </div>
	</form>
</body>
</html>