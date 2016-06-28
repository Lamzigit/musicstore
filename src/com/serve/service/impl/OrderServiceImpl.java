package com.serve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serve.dao.OrderDao;
import com.serve.entity.Orders;
import com.serve.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public List<Orders> getDeliveriedOrderList() {
		
		return orderDao.getDeliveriedOrderList();
	}

	@Override
	public List<Orders> getOrderListById(int id) {
		
		return orderDao.getOrderListById(id);
	}

	@Override
	public boolean addOrder(Orders order) {
		// TODO Auto-generated method stub
		return orderDao.addOrder(order);
	}

	@Override
	public boolean deleteOrder(int orderid) {
		// TODO Auto-generated method stub
		return orderDao.deleteOrder(orderid);
	}

	@Override
	public boolean updateOrder(Orders order) {
		// TODO Auto-generated method stub
		return orderDao.updateOrder(order);
	}

	@Override
	public List<Orders> getNotDeliveryOrderList() {
		// TODO Auto-generated method stub
		return orderDao.getNotDeliveryOrderList();
	}

	@Override
	public Orders getOrderById(int OrderId) {
		// TODO Auto-generated method stub
		return orderDao.getOrderById(OrderId);
	}

}
