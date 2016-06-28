package com.serve.service;

import java.util.List;

import com.serve.entity.Orders;

public interface OrderService {
	
	public List<Orders> getDeliveriedOrderList();
	
	public List<Orders> getOrderListById(int id);
	
	public List<Orders> getNotDeliveryOrderList();
	
	public Orders getOrderById(int OrderId);
	
	public boolean addOrder(Orders order);
	
	public boolean deleteOrder(int orderid);
	
	public boolean updateOrder(Orders order);
}
