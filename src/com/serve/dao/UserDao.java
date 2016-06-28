package com.serve.dao;

import java.util.List;

import com.serve.entity.User;

public interface UserDao {
	
	public User getUserById(int id);
	
	public User getUserByUsername(String username);
	
	public List<User> getAllUser();
	
	public boolean addUser(User user);
	
	public boolean delUser(String id);
	
	public boolean updUser(User user);
}
