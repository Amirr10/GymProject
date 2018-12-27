package com.hit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hit.model.Activity;
import com.hit.model.User;

/**
 * @author Yaniv Nadav, Nir Rozmarin and Amir Rahav
 * @version 1.0
 * @since December 2018
 * 
 * 
 * */

public class GymDAOImpl implements IGymDAO {
	
	//SessionFactory
	private SessionFactory sessionFactory;
	
	//Singleton
	private static GymDAOImpl instance = null;
	
	/**
	 * Private Constructor
	 * */
	private GymDAOImpl() {
		this.sessionFactory =  new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).addAnnotatedClass(Activity.class).buildSessionFactory();
	}
	
	/**
	 * Singleton Design Pattern getInstance method
	 * @return GymDAOImpl instance
	 * */
	public static GymDAOImpl getInstance() {
		
		if(instance == null) {
			instance = new GymDAOImpl();
		}
		return instance;
	}
	
	/**
	 * Opening and returning new Session
	 * @return Session
	 */
	 
	public Session openSession() {
		return this.sessionFactory.openSession();
	}
	
	/**
	 * Closing SessionFactory.
	 * 
	 */
	public void closeSession() {
		this.sessionFactory.close();
	}
	
	/**
	 * Adding new user to the database
	 * @param user New user
	 * @return True if user added, false if not
	 * */
	@Override
	public boolean addUser(User user) {
		
		//Check if user with parameters already exist
		
		if(!(this.checkUserExist(user.getEmail())))
		{	
			//create new Session
			Session session = this.openSession();
	
			//start transaction
			session.beginTransaction();
			
			//save the user in db
			session.save(user);
			
			//commit the transaction
			session.getTransaction().commit();
			
			// close Session
			
			session.close();
	
			return true;
		}
		
		else
			return false;
		
		
	}
	
	/**
	 * Return list of all users from database
	 * @return  List 
	 * */
	public List<User> getAllUsers() {
		
		//create new Session
		Session session = this.openSession();
		
		//start transaction
		session.beginTransaction();
		
		List<User> users = session.createQuery("from User").getResultList();
		
		session.close();
		
		return users;
	}

	/**
	 * Checks if user exist in database
	 * @param user User
	 * @return true if user exist, false if not.
	 * */
	public boolean checkUserExist(String email) {
		
		//create new Session
		Session session = this.openSession();
		
		//start transaction
		session.beginTransaction();
		

		List<User> users = session.createQuery("from User where email = '" + email + "'").getResultList();
		
		session.close();
		if(users.size() == 0 || users.size()>1)
			return false;
		else
			return true;
			
	}
	
	// add new Activity
	/**
	 * Adds new activity to user
	 * @param activity Activity
	 * @param user_id User ID
	 * */
	@Override
	public boolean addActivity(Activity activity, int user_id) {
		
		
		//create new Session
		Session session = this.openSession();
		
		//start transaction
		session.beginTransaction();
		
		User user = session.get(User.class, user_id);
		
//		List<Activity> activities = user.getActivites();
//		
//		for(int i = 0; i<activities.size(); i++)
//		{
//			if(activities.get(i).getWorkoutName().equals(activity.getWorkoutName()))
//				return false;
//		}
				
		user.addActivity(activity);
		
		
		//commit the transaction
		session.getTransaction().commit();
		
		//close session
		session.close();
		
		return true;
		
		
	}

	/**
	 * Updates activity of specific user
	 * @param updated_activity Activity
	 * @param user_id User ID
	 * */
	@Override
	public void updateActivity(Activity updated_activity, int user_id) {
		
		
		//create new Session
		Session session = this.openSession();
		
		//start transaction
		session.beginTransaction();
		
		User user = session.get(User.class, user_id);
		
		List<Activity> activities = user.getActivites();
		
		//find the specific activity from the user activities and update 
		for(int i=0; i<activities.size(); i++)
		{

			Activity old_activity = activities.get(i);

			if(old_activity.getWorkoutName().equals(updated_activity.getWorkoutName()))
			{
				activities.remove(old_activity);
				activities.add(updated_activity);
			}

		}
			
		//commit the transaction
		session.getTransaction().commit();
		
		//close session
		session.close();
		
	}

	/**
	 * Deletes activity of specific user
	 * @param deleted_activity Activity
	 * @param user_id User ID
	 * */
	@Override
	public void deleteActivity(Activity deleted_activity, int user_id) {
		
		//create new Session
		Session session = this.openSession();
		
		//start transaction
		session.beginTransaction();
		
		User user = session.get(User.class, user_id);
		
		List<Activity> activities = user.getActivites();
		
		//find the specific activity from the user activities and update 
		for(int i=0; i<activities.size(); i++)
		{

			Activity activity = activities.get(i);

			if(activity.getWorkoutName().equals(deleted_activity.getWorkoutName()))
			{
				activities.remove(activity);
			}

		}
			
		//commit the transaction
		session.getTransaction().commit();
		
		//close session
		session.close();
		
	}

//	// returns Activities of a user
//	/**
//	 * returns Activities of a user
//	 * @param deleted_activity Activity
//	 * @param user_id User ID
//	 * */
//	@Override
//	public List<Activity> getActivities(int user_id) {
//		
//		//create new Session
//		Session session = this.openSession();
//		
//		
//		//start transaction
//		session.beginTransaction();
//		
//		User user = session.get(User.class, user_id);
//		
//		List<Activity> activities = user.getActivites();
//		
//
//		//commit the transaction
//		session.getTransaction().commit();
//		
//		//close session
//		session.close();
//		
//		return activities;
//	}
	
	// update user
	/**
	 * Updates user details
	 * @param user User
	 * @return true if user updated successfully, false if not.*/
	@Override
	public boolean updateUser(int user_id ,User updated_user) {
		
		//create new Session
		Session session = this.openSession();
		
		//start transaction
		session.beginTransaction();
		
		//update user details
		
		
		User user = session.get(User.class,user_id);
		
		
		user.setFirstName(updated_user.getFirstName());
		user.setLastName(updated_user.getLastName());
		user.setPassword(updated_user.getPassword());
		
		
//		session.save(user);
		
		//commit the transaction
		session.getTransaction().commit();
		
		//close session
		session.close();
		
		return true;
	}
	
	/**
	 * Removes user from database
	 * @param user_id User ID
	 * @return true if user removed, false if not.
	 * */
	@Override
	public boolean removeUser(int user_id) {
		
		//create new Session
		Session session = this.openSession();
		
		//start transaction
		session.beginTransaction();
		
		//get the user from db
		User user = session.get(User.class, user_id);
		
		
		//update user details
		
		//if user not found in db return false
		if(user==null)
			return false;
		
		session.remove(user);
		
		
		//commit the transaction
		session.getTransaction().commit();
		
		//close session
		session.close();
		
		return true;

	}
	
	/**
	 * Return user from database
	 * @param user_name User Name
	 * */
	@Override
	public User getUser(String email) {
		
		
		List<User> users = this.getAllUsers();
		
		for(int i=0; i<users.size(); i++)
		{
			if(users.get(i).getEmail().equals(email))
				return users.get(i);
		}
		
		
		return null;
	}






}
