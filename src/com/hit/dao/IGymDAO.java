package com.hit.dao;

import java.util.List;

import com.hit.model.Activity;
import com.hit.model.User;

public interface IGymDAO {
	
	public boolean addUser(User user);
	public void addActivity(Activity activity, int user_id);
	public void updateActivity(Activity activity, int user_id);
	public void deleteActivity(Activity activity, int user_id);
	public List<Activity> getActivities(int user_id);

	public boolean checkUserExist(User user);
	public List<User> getAllUsers();
	public void updateUser(User user);
}
