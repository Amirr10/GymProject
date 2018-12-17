package com.hit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hit.dao.GymDAOImpl;
import com.hit.dao.IGymDAO;
import com.hit.model.User;

public class LoginController {
	
	public void login(HttpServletRequest request, HttpServletResponse response, String str) throws IOException
	{
		PrintWriter out = response.getWriter();
		
		//get singleton instance
		IGymDAO dao = GymDAOImpl.getInstance();		
		

		String email = request.getParameter("email");
		String password = request.getParameter("psw");
		
		if(!(dao.checkUserExist(email)))
			out.println("User dosn't exist, please try again...");
		else
		{
			User user = dao.getUser(email);
			if(user.getPassword().equals(password))
				out.println("Hi " + user.getFirstName() + ", you logged in.");
			
		}
		
			
	}

}
