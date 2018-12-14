package com.hit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hit.model.Activity;
import com.hit.model.User;

public class GymDAOImpl implements IGymDAO {
	
	//SessionFactory
	
	private SessionFactory sessionFactory;
	
	//Singleton

	private static GymDAOImpl instance = null;
	
	
	private GymDAOImpl() {
		this.sessionFactory =  new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).addAnnotatedClass(Activity.class).buildSessionFactory();
	}
	
	public static GymDAOImpl getInstance() {
		
		if(instance == null) {
			instance = new GymDAOImpl();
		}
		return instance;
	}
	
	// open new Session
	
	public Session openSession() {
		return this.sessionFactory.openSession();
	}
	
	// close Session
	public void closeSession() {
		this.sessionFactory.close();
	}
	
	// add new User
	@Override
	public boolean addUser(User user) {
		
		//Check if user with parameters already exist
		
		if(!(this.checkUserExist(user)))
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
	
	// get all users from db
	public List<User> getAllUsers() {
		
		//create new Session
		Session session = this.openSession();
		
		//start transaction
		session.beginTransaction();
		
		List<User> users = session.createQuery("from User").getResultList();
		
		session.close();
		
		return users;
	}

	// check if user exist in db
	public boolean checkUserExist(User user) {
		
		//create new Session
		Session session = this.openSession();
		
		//start transaction
		session.beginTransaction();
		

		List<User> users = session.createQuery("from User where firstname = '" + user.getFirstName() + "'").getResultList();
		
		session.close();
		if(users.size() == 0 || users.size()>1)
			return false;
		else
			return true;
			
	}
	
	// add new Activity
	@Override
	public boolean addActivity(Activity activity, int user_id) {
		
		
		//create new Session
		Session session = this.openSession();
		
		//start transaction
		session.beginTransaction();
		
		User user = session.get(User.class, user_id);
		
		List<Activity> activities = user.getActivites();
		
		for(int i = 0; i<activities.size(); i++)
		{
			if(activities.get(i).getWorkoutName().equals(activity.getWorkoutName()))
				return false;
		}
				
		user.addActivity(activity);
		
		
		//commit the transaction
		session.getTransaction().commit();
		
		//close session
		session.close();
		
		return true;
		
		
	}

	// update exist Activity
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

	// delete exist Activity
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

	// returns Activities of a user
	@Override
	public List<Activity> getActivities(int user_id) {
		
		//create new Session
		Session session = this.openSession();
		
		
		//start transaction
		session.beginTransaction();
		
		User user = session.get(User.class, user_id);
		
		List<Activity> activities = user.getActivites();
		

		//commit the transaction
		session.getTransaction().commit();
		
		//close session
		session.close();
		
		return activities;
	}
	
	// update user
	@Override
	public boolean updateUser(User user) {
		
		//create new Session
		Session session = this.openSession();
		
		//start transaction
		session.beginTransaction();
		
		//update user details
		session.update(user);
		
		
		//commit the transaction
		session.getTransaction().commit();
		
		//close session
		session.close();
		
		return true;
	}
	
	// remove user
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






}
