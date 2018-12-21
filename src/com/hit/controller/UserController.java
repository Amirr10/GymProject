package com.hit.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hit.model.User;

public class UserController {
	
	public void addActivity(HttpServletRequest request, HttpServletResponse response, String str) throws IOException
	{
		
		System.out.println("inside addActivity method with activity clicked: " + str);
//		response.sendRedirect("/GymPro/add_activity.jsp");

	}
	
	public void getPage(HttpServletRequest request, HttpServletResponse response, String str) throws IOException
	{
		System.out.println(str);
		if(str.equals("addActivity"))
			response.sendRedirect("/GymPro/add_activity.jsp");
		else if (str.equals("myActivities"))
			response.sendRedirect("/GymPro/my_activities.jsp");
		else if (str.equals("myReports"))
			response.sendRedirect("/GymPro/my_reports.jsp");


	}

	
	public void index(HttpServletRequest request, HttpServletResponse response, String str) throws IOException
	{
		
		System.out.println("inside index method.");
		response.sendRedirect("/GymPro/index.jsp");

	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response, String str) throws IOException
	{
	       HttpSession session = request.getSession();
	       if(session.getAttribute("user") != null){
	            session.removeAttribute("user");
	            response.sendRedirect("/GymPro/login.jsp");
	       }
	}
}
