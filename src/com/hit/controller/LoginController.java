package com.hit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hit.dao.GymDAOImpl;
import com.hit.dao.IGymDAO;
import com.hit.model.User;

public class LoginController {
	
	public void login(HttpServletRequest request, HttpServletResponse response, String str) throws IOException
	{
		HttpSession session = request.getSession(false);
		
		PrintWriter out = response.getWriter();
		
		//get singleton instance
		IGymDAO dao = GymDAOImpl.getInstance();		
		
		//get login request params
		String email = request.getParameter("email");
		String password = request.getParameter("psw");
		
		//check if user with the same params exist
		if(!(dao.checkUserExist(email)))
			response.sendRedirect("/GymPro/login_error.jsp");
		else
		{
			User user = dao.getUser(email);
			String user_pass = user.getPassword();
			if(user_pass.equals(password))
			{
				System.out.println("user found in db and password equal.");
				session.setAttribute("user", user);
				response.sendRedirect("/GymPro/index.jsp");

			} else {
				response.sendRedirect("/GymPro/login_error.jsp");
				
			}
			
		}
		
			
	}

}
