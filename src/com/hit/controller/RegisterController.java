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
		
        String buttonClicked = request.getParameter("kb");
		

		
		if(buttonClicked.equals("LOGIN"))
		{
			response.sendRedirect("/GymPro/login.jsp");
			return;
		}
		
		//get singleton instance
		IGymDAO dao = GymDAOImpl.getInstance();		
		
		String first_name = request.getParameter("firstName");
		String last_name = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("psw");
		String rePassword = request.getParameter("rpsw");
		
		if(first_name.isEmpty()|| last_name.isEmpty()|| email.isEmpty() || password.isEmpty() || rePassword.isEmpty())
			response.sendRedirect("/GymPro/register.jsp");
		
		if(!(password.equals(rePassword)))
		{
			response.sendRedirect("/GymPro/register.jsp");
		} else {
			
			User newUser = new User(email,first_name, last_name, password);
			
			//check if use with same email exist
			if(dao.checkUserExist(email))
				response.sendRedirect("/GymPro/register.jsp");
			else 
			{
				dao.addUser(newUser);
				response.sendRedirect("/GymPro/login.jsp");
			}
		}	
	}
	
	public void getPage(HttpServletRequest request, HttpServletResponse response, String str) throws IOException
	{
		
		response.sendRedirect("/GymPro/register.jsp");
		
	}

}
