package com.hit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		
        String buttonClicked = request.getParameter("kb");
		
		System.out.println("Context path: " + request.getContextPath() + "");

		
		if(buttonClicked.equals("REGISTER"))
		{
			System.out.println("clicked register");
			response.sendRedirect("/GymPro/register.jsp");
//			response.sendRedirect(request.getContextPath() + "/index.jsp");
//			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/register.jsp");
//           try {
//			dispatcher.forward(request,response);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			response.sendRedirect(request.getContextPath() + "/controller/RegisterController/getPage");

			return;
		}
		//get singleton instance
		IGymDAO dao = GymDAOImpl.getInstance();	
		
		//get login request params
		String email = request.getParameter("email");
		String password = request.getParameter("psw");
		
		//check if user with the same params exist
		if(!(dao.checkUserExist(email)))
		{
			response.sendRedirect("/GymPro/login_error.jsp");
			return;
		}
		else
		{
			User user = dao.getUser(email);
			String user_pass = user.getPassword();
			if(user_pass.equals(password))
			{
				System.out.println("user found in db and password equal.");
				session.setAttribute("user", user);
				response.sendRedirect("/GymPro/index.jsp");
				return;

			} else {
				response.sendRedirect("/GymPro/login_error.jsp");
				return;
			}
			
		}
		
			
	}

}
