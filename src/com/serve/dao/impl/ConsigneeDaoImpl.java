package com.serve.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.serve.dao.ConsigneeDao;
import com.serve.entity.Consignee;

@Repository
public class ConsigneeDaoImpl implements ConsigneeDao{
	
	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public List<Consignee> getConsigneeList() {
		String hql = "from Consignee";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		return q.list();
	}

	@Override
	public List<Consignee> getConsigneeByUsername(String username) {
		String hql = "from Consignee con where  con.username = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, username);
		return query.list();
	}

	@Override
	public boolean addConsignee(Consignee consignee) {
		sessionFactory.getCurrentSession().save(consignee);
		return false;
	}

	@Override
	public boolean deleteConsignee(int id) {
		String hql = "delete Consignee con where con.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateConsignee(Consignee consignee) {
		String hql = "update Consignee c set c.consignee = ?,c.deliverAddress = ?,c.phone = ?,c.tel = ?,c.username = ?,where c.Id = £¿";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setString(0, consignee.getConsignee());
		q.setString(1, consignee.getDeliverAddress());
		q.setString(2, consignee.getPhone());
		q.setString(3, consignee.getTel());
		q.setString(4, consignee.getUsername());
		q.setInteger(5, consignee.getId());
		
		return (q.executeUpdate() > 0);
	}

	@Override
	public Consignee getConsigneeById(int consigneeid) {
		String hql = "from Consignee c where c.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, consigneeid);
		
		return (Consignee)query.uniqueResult();
	}

}
