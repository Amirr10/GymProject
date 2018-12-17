package com.hit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.dao.GymDAOImpl;
import com.hit.dao.IGymDAO;
import com.hit.model.User;

public class RegisterController {
	
	public void register(HttpServletRequest request, HttpServletResponse response, String str) throws IOException
	{
		PrintWriter out = response.getWriter();
		
		//get singleton instance
		IGymDAO dao = GymDAOImpl.getInstance();		
		
		String first_name = request.getParameter("firstName");
		String last_name = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("psw");
		String rePassword = request.getParameter("rpsw");
		
		if(!(password.equals(rePassword)))
		{
			out.println("Passwords don't match...");

		} else {
			
			User newUser = new User(email,first_name, last_name, password);
			
			//check if use with same email exist
			if(dao.checkUserExist(email))
					out.println("Failed to register, User Exist.");
			else 
			{
				dao.addUser(newUser);
				out.println("You have successfully registered.");
			}
		}
		
		
			
	}

}
