package com.serve.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.serve.dao.OrderDao;
import com.serve.entity.Orders;

@Repository
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Orders> getDeliveriedOrderList() {
		String hql = "from Orders o where o.isPay = 1 and o.IsDeliveried = 1";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		return q.list();
	}

	@Override
	public List<Orders> getOrderListById(int id) {
		String hql = "from Orders o where o.user.id = ?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setInteger(0, id);
		return q.list();
	}

	@Override
	public boolean addOrder(Orders order) {
		
		return (((Integer)sessionFactory.getCurrentSession().save(order)) > 0);
	}

	@Override
	public boolean deleteOrder(int orderid) {
		String hql = "delete Orders o where o.id = ?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setInteger(0, orderid);
		return (q.executeUpdate() > 0);
	}

	@Override
	public boolean updateOrder(Orders order) {
		String hql = "update Orders o set o.IsDeliveried = ?,o.isPay=?,o.OrderDate =?,o.payMethod=?,o.remark=?,o.totalpayment=?,o.totalquantity=?,o.user.id =? ,o.consignee.id = ? where o.Id = ?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setLong(0, order.getIsDeliveried());
		q.setLong(1, order.getIsPay());
		q.setDate(2, order.getOrderDate());
		q.setInteger(3, order.getPayMethod());
		q.setString(4, order.getRemark());
		q.setDouble(5, order.getTotalpayment());
		q.setDouble(6, order.getTotalquantity());
		q.setInteger(7, order.getUser().getId());
		q.setInteger(8, order.getConsignee().getId());
		q.setInteger(9, order.getId());
		return q.executeUpdate() >0;
	}

	@Override
	public List<Orders> getNotDeliveryOrderList() {
		String hql = "from Orders o where o.isPay = 1 and o.IsDeliveried = 0";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		return q.list();
	}

	@Override
	public Orders getOrderById(int OrderId) {
		String hql = "from Orders o where o.id = ?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setInteger(0, OrderId);
		return (Orders)q.uniqueResult();
	}

}
