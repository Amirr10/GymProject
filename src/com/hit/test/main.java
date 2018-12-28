package com.hit.test;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hit.dao.IGymDAO;
import com.hit.dao.GymDAOImpl;
import com.hit.model.Activity;
import com.hit.model.User;
 
public class main {

	public static void main(String[] args) {
		
		//get singleton instance
		IGymDAO dao = GymDAOImpl.getInstance();
//		
//		//create new user
//		User daniel = new User("daniel@gmail.com", "Daniel", "David", "123456" );
//		
//		System.out.println(dao.addUser(daniel));
//		
//		//we create list of Activities
//		Activity backActivity = new Activity("back", 4, 8);
//		Activity runActivity = new Activity("run", 10, 10);
//		Activity legsActivity = new Activity("legs", 5, 8);
//		
//		//getting user from db by firstname ( need to change to email)		
//		User danielFromDB = dao.getUser(daniel.getFirstName());
//		
//		//adding activity to user		
//		dao.addActivity(backActivity, danielFromDB.getId());
//		dao.addActivity(runActivity, danielFromDB.getId());
//		dao.addActivity(legsActivity, danielFromDB.getId());
//
//
//		
//		//update user password
//		daniel.setPassword("123abc");
//		dao.updateUser(danielFromDB.getId(), danielFromDB);
//		
//		//remove activity
//		dao.deleteActivity(runActivity, danielFromDB.getId());
//		
//		//check if user exist
//		System.out.println("Check if user with daniel exist in db: " +dao.checkUserExist(daniel.getEmail()));
//		
		
		
		User yaniv = dao.getUser("yanivnadav93@gmail.com");
		List<Activity> list = yaniv.getActivites();
		System.out.println(list.toString());
		Collections.sort(list, new Comparator<Activity>() {
	    @Override
	    public int compare(Activity a1, Activity a2) {
	        // TODO Auto-generated method stub
	        return a1.getDate_created().compareTo(a2.getDate_created());
	    	}
		});
		
		System.out.println(list.toString());

		
		

		

		
	}
}
