package com.hit.dao;

import java.util.List;

import com.hit.model.Activity;
import com.hit.model.User;

public interface IGymDAO {
	
	public boolean addUser(User user);
	public boolean removeUser(int user_id);
	public boolean updateUser(int user_id,User user);
	public boolean checkUserExist(String email);
	public List<User> getAllUsers();
	public User getUser(String user_email);


	public boolean addActivity(Activity activity, int user_id);
	public void updateActivity(Activity updated_activity);
	public void deleteActivity(int deleted_activity_id);
	public Activity getActivity (int activity_id);


}
