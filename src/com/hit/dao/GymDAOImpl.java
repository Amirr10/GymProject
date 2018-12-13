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
//		
//		if(!(this.checkUserExist(user)))
//		{	
			//create new Session
			Session session = this.openSession();
	
			//start transaction
			session.beginTransaction();
			
			//save the user in db
//			session.save(user);
			session.saveOrUpdate(user);
			//commit the transaction
			session.getTransaction().commit();
			
			// close Session
			
			session.close();
	
			return true;
//		}
//		
//		else
//			return false;
		
		
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
	public void addActivity(Activity activity, int user_id) {
		
		
		//create new Session
		Session session = this.openSession();
		
		//start transaction
		session.beginTransaction();
		
		User user1 = session.get(User.class, user_id);
		
		user1.addActivity(activity);
		
		
		//commit the transaction
		session.getTransaction().commit();
		
		//close session
		session.close();
		
		
	}

	@Override
	public void updateActivity(Activity activity, User id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Activity activity, User id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		
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
	}

//	public Activity getActivityById(int id) {
//		return (Activity)instance.
//	}
}
