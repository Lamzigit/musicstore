package com.serve.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.serve.dao.OrderDetailDao;
import com.serve.entity.Orderdetail;
import com.serve.entity.Orders;

@Repository
public class OrderDetailDaoImpl implements OrderDetailDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Orderdetail> getOrderedetailListByAlbumId(int AlbumId) {
		String hql = "from Orderdetail od where od.AlbumId = ?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setInteger(0, AlbumId);
		return q.list();
	}

	@Override
	public List<Orderdetail> getOrderedetailListByOrderId(int OrderId) {
		String hql = "from Orderdetail od where od.OrderId = ?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setInteger(0, OrderId);
		return q.list();
	}
	
	@Override
	public boolean addOrderdetail(Orderdetail orderdetail) {
		// TODO Auto-generated method stub
		return ((Integer)sessionFactory.getCurrentSession().save(orderdetail)>0);
	}

	@Override
	public boolean deleteOrderdetail(int ordetdetailId) {
		String hql = "delete Orderdetail od where od.Id = ?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setInteger(0, ordetdetailId);
		return (q.executeUpdate() > 0);
	}

	@Override
	public boolean updateOrderdetail(Orderdetail orderdetail) {
		// TODO Auto-generated method stub
		String hql = "update Orderdetail od set od.AlbumId = ?,od.Quantity = ?,od.UnitPrice = ? where od.Id = ?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setInteger(0, orderdetail.getAlbumId());
		q.setInteger(1, orderdetail.getQuantity());
		q.setDouble(2, orderdetail.getUnitPrice());
		q.setInteger(3, orderdetail.getId());
		return (q.executeUpdate()  > 0);
	}

	@Override
	public Orders getCurrentOrderById(int id) {
		String hql = "from Orders ors where ors.user.id = ? and ors.isPay = ?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setInteger(0, id);
		q.setInteger(1, 0);
		return (Orders)q.uniqueResult();
	}

}
