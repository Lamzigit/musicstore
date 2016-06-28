package com.serve.service;

import java.util.List;  
  
import com.serve.entity.User;  
  
public interface UserService {  
  
    public User getUserById(int id); 
    
    public User getUserByUsername(String username);
      
    public List<User> getAllUser();  
      
    public boolean addUser(User user);  
      
    public boolean delUser(String id);  
      
    public boolean updateUser(User user);  
} 
