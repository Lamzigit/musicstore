package com.serve.dao;

import java.util.List;

import com.serve.entity.Orderdetail;
import com.serve.entity.Orders;

public interface OrderDetailDao {
	public List<Orderdetail> getOrderedetailListByAlbumId(int AlbumId);
	
	public List<Orderdetail> getOrderedetailListByOrderId(int OrderId); 
	
	public Orders getCurrentOrderById(int id);
	
	public boolean addOrderdetail(Orderdetail orderdetail);
	
	public boolean deleteOrderdetail(int ordetdetailId);
	
	public boolean updateOrderdetail(Orderdetail orderdetail);
}
