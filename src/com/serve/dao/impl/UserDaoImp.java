package com.serve.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.serve.dao.UserDao;
import com.serve.entity.User;

@Transactional
@Repository
public class UserDaoImp implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getUserById(int id) {
		
		String hql = "from User u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		return (User)query.uniqueResult();
	}

	@Override
	public List<User> getAllUser() {
		String hql = "from User";
		Session ss = sessionFactory.getCurrentSession();
		Query query = ss.createQuery(hql);
				
		return query.list();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED) 	
	public boolean addUser(User user) {
		//System.out.println(user.getId()+"   "+user.getUsername()+"   "+user.getPassword()+"   "+user.getAddress()+"   "+user.getEmail()+"   "+user.getName());
		sessionFactory.getCurrentSession().save(user);
		return true;
	}

	@Override
	public boolean delUser(String id) {
		String hql = "delete User user where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		
		return (query.executeUpdate()>0);		
	}

	@Override
	public boolean updUser(User user) {
		
		String hql = "update User u set u.username=?,u.password=?,u.nickname=?,u.address=?,u.phone=?,u.email=? where u.id= ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getUsername());
		query.setString(1, user.getPassword());
		query.setString(2, user.getNickname());
		query.setString(3, user.getAddress());
		query.setString(4, user.getPhone());
		query.setString(5, user.getEmail());
		query.setInteger(6, user.getId());
		
		return (query.executeUpdate() > 0);
	}

	@Override
	public User getUserByUsername(String username) {
		String hql = "from User u where u.username=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, username);
		
		return (User)query.uniqueResult();
	}

}
