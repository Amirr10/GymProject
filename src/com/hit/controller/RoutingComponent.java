package com.hit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RoutingComponent
 */
@WebServlet("/controller/*")
public class RoutingComponent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoutingComponent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//String str = request.getServletPath();
				String str = request.getRequestURI();
				PrintWriter out = response.getWriter();
				//out.println(str);
				//System.out.println("Path is :" + str);
				
				
				
			     String[] st = str.split("/");
			     String controllerName = "com.hit.controller."+st[3];
			     String actionName = st[4];
			     String strAfterAction = null;

			     
			     
				
				//Instantiating the controller class
				try {
					Class controllerClass = Class.forName(controllerName);
					Object controller = controllerClass.newInstance();
					
					Method method = controllerClass.getMethod
							(actionName, HttpServletRequest.class , HttpServletResponse.class , String.class);
					method.invoke(controller,request,response,strAfterAction);
					
					
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
