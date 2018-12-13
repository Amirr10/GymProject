package com.hit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hit.dao.IGymDAO;
import com.hit.dao.GymDAOImpl;
import com.hit.model.Activity;
import com.hit.model.User;

public class main {

	public static void main(String[] args) {

		IGymDAO dao = GymDAOImpl.getInstance();
		
//		User yaniv = new User("Yaniv", "Nadav", "222222" );
//		User amir = new User("Amir", "Rahav", "1111" );
//		
//		Activity backActivity = new Activity("back", 2, 10);
//		Activity runActivity = new Activity("run", 10, 10);
//		Activity legsActivity = new Activity("legs", 5, 8);
//
//		
//		dao.addActivity(backActivity, 6);
//		dao.addActivity(runActivity, 7);
//		dao.addActivity(legsActivity, 7);
		
		System.out.println(dao.getAllUsers().toString());

		

		
	}
}
