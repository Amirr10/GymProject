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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RoutingComponent
 */
@WebServlet(value = {"/controller/*", "/"})
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
				
				HttpSession session = request.getSession(false);
				
				
				String str = request.getRequestURI();
				PrintWriter out = response.getWriter();
				
				System.out.println("Path is :" + str);

				String controllerName = null, actionName = null, strAfterAction = null;
				
			     String[] st = str.split("/");
			     if(!str.endsWith("controller")) {
				     controllerName = "com.hit.controller."+st[3];
				     actionName = st[4];
				     System.out.println(st.length);
				     if(st.length > 5)
				    	 strAfterAction = st[5];
			     }
			     

				
				
				if ((session.getAttribute("user") == null) && actionName==null){
					System.out.println("User in session is null");
				    response.sendRedirect("/GymPro/login.jsp"); // Not logged in, redirect to login page.
				    return ;
				}


			     
			     
				
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
