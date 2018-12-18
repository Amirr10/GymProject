package com.hit.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController {
	
	public void addActivity(HttpServletRequest request, HttpServletResponse response, String str) throws IOException
	{
		
		System.out.println("inside addActivity method.");
		response.sendRedirect("/GymPro/add_activity.jsp");

	}

	public void myActivities(HttpServletRequest request, HttpServletResponse response, String str) throws IOException
	{
		
		System.out.println("inside myActivities method.");
		response.sendRedirect("/GymPro/my_activities.jsp");

	}
	
	public void myReports(HttpServletRequest request, HttpServletResponse response, String str) throws IOException
	{
		
		System.out.println("inside myActivities method.");
		response.sendRedirect("/GymPro/my_reports.jsp");

	}
}
