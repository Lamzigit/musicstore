package com.serve.dao;

import java.util.List;

import com.serve.entity.Orders;

public interface OrderDao {
	
	public List<Orders> getDeliveriedOrderList();
	
	public List<Orders> getNotDeliveryOrderList();
	
	public List<Orders> getOrderListById(int id);
	
	public Orders getOrderById(int OrderId);
	
	public boolean addOrder(Orders order);
	
	public boolean deleteOrder(int orderid);
	
	public boolean updateOrder(Orders order);
}
