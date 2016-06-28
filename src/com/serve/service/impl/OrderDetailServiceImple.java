package com.serve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serve.dao.OrderDetailDao;
import com.serve.entity.Orderdetail;
import com.serve.entity.Orders;
import com.serve.service.OrderDetailService;

@Service
public class OrderDetailServiceImple implements OrderDetailService{
	
	@Autowired
	private OrderDetailDao orderdetaildao;
	@Override
	public List<Orderdetail> getOrderedetailListByAlbumId(int AlbumId) {
		// TODO Auto-generated method stub
		return orderdetaildao.getOrderedetailListByAlbumId(AlbumId);
	}

	@Override
	public List<Orderdetail> getOrderedetailListByOrderId(int OrderId) {
		// TODO Auto-generated method stub
		return orderdetaildao.getOrderedetailListByOrderId(OrderId);
	}

	@Override
	public boolean addOrderdetail(Orderdetail orderdetail) {
		// TODO Auto-generated method stub
		return orderdetaildao.addOrderdetail(orderdetail);
	}

	@Override
	public boolean deleteOrderdetail(int ordetdetailId) {
		// TODO Auto-generated method stub
		return orderdetaildao.deleteOrderdetail(ordetdetailId);
	}

	@Override
	public boolean updateOrderdetail(Orderdetail orderdetail) {
		// TODO Auto-generated method stub
		return orderdetaildao.updateOrderdetail(orderdetail);
	}

	@Override
	public Orders getCurrentOrderById(int id) {
		// TODO Auto-generated method stub
		return orderdetaildao.getCurrentOrderById(id);
	}

}
