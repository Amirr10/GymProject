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

	<form action="controller/RegisterController/register" method="post">
	
		<table>	
		    <tr>
		   		<td>E-mail:</td>
		    	<td>
		    		<input type="text" id="email" placeholder="Enter E-mail" name="email" >
	    		</td>
		    </tr>
			<tr>	    
	   	    	<td>First Name:</td>
		    	<td>
		    		<input type="text" id="fName" placeholder="Enter First Name" name="firstName" >
	    		</td>
		    </tr>
		    <tr>
	   	   		<td>Last Name:</td>
		  		<td>
		  			<input type="text" id="lName" placeholder="Enter Last Name" name="lastName" >
	  			</td>
			</tr>
			<tr>
		    	<td>Password:</td>
		    	<td>
		    		<input type="password" placeholder="Enter Password" name="psw" >
	    		</td>
	   	    </tr>
	   	    <tr>
	  	    	<td>Re-Password:</td>
		    	<td>
		    		<input type="password" placeholder="Re-Enter Password" name="rpsw" >
	    		</td>
		    </tr>
			<tr>
	   	    	<td>
	   	    		<button type="submit" value="LOGIN" name="kb" >Back</button>
	   	    	</td>
	  	   		<td>
	  	   			<button type="submit" value="REGISTER" name="kb" >Sign Up</button>
	  			</td>
	   	    </tr>
		
	    </table>
  	    
	</form>
</body>
</html>