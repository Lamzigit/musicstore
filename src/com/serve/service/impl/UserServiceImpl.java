package com.serve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serve.dao.UserDao;  
import com.serve.entity.User;
import com.serve.service.UserService;  

@Service
public class UserServiceImpl implements UserService { 
	
	@Autowired
    private UserDao userDao;  
      
    public void setUserDao(UserDao userDao) {  
        this.userDao = userDao;  
    }  
  
    @Override  
    public User getUserById(int id) {  
        return userDao.getUserById(id);  
    }  
  
    @Override  
    public List<User> getAllUser() {  
        return userDao.getAllUser();  
    }  
  
    @Override  
    public boolean addUser(User user) {  
        return userDao.addUser(user);  
    }  
  
    @Override  
    public boolean delUser(String id) {  
          
        return userDao.delUser(id);  
    }  
  
    @Override  
    public boolean updateUser(User user) {  
        return userDao.updUser(user);  
    }

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}  
  
} 