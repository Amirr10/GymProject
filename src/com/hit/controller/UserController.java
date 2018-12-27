package com.hit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hit.dao.GymDAOImpl;
import com.hit.dao.IGymDAO;
import com.hit.model.Activity;
import com.hit.model.User;

public class UserController {
	
	//get singleton instance
	IGymDAO dao = GymDAOImpl.getInstance();
	
	public void addActivity(HttpServletRequest request, HttpServletResponse response, String str) throws IOException
	{
		HttpSession session = request.getSession(false);
		User session_user = (User) session.getAttribute("user");
		
		String activity_name = request.getParameter("activity_name");
		String activity_reps = request.getParameter("reps");
		String activity_sets = request.getParameter("sets");
		
		if(activity_name.equals("#") || activity_reps.equals("#") || activity_sets.equals("#") )
		{
			response.sendRedirect("/GymPro/add_activity.jsp");
			return;
		}

		int reps = Integer.parseInt(activity_reps);
		int sets = Integer.parseInt(activity_sets);
		
		Activity activity = new Activity(activity_name, reps, sets);
		
		        
        dao.addActivity(activity, session_user.getId());
		response.sendRedirect("/GymPro/index.jsp");

	}
	
	public void getPage(HttpServletRequest request, HttpServletResponse response, String str) throws IOException
	{
		System.out.println(str);
		if(str.equals("addActivity"))
			response.sendRedirect("/GymPro/add_activity.jsp");
		else if (str.equals("myActivities"))
		{
			HttpSession session = request.getSession(false);
			User user = (User) session.getAttribute("user");
	        List<Activity> userActivities = dao.getUser(user.getEmail()).getActivites();
			request.setAttribute("activities", userActivities);
	        try {
				request.getRequestDispatcher("/my_activities.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (str.equals("myReports"))
			response.sendRedirect("/GymPro/my_reports.jsp");
		else if (str.equals("home"))
			response.sendRedirect("/GymPro/index.jsp");

			


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
