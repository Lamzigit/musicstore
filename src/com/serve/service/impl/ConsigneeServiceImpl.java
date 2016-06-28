package com.serve.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serve.dao.ConsigneeDao;
import com.serve.entity.Consignee;
import com.serve.service.ConsigneeService;

@Service
public class ConsigneeServiceImpl implements ConsigneeService{
	
	@Autowired
	private ConsigneeDao consigneeDao;
	
	@Override
	public List<Consignee> getConsigneeList() {
		// TODO Auto-generated method stub
		return consigneeDao.getConsigneeList();
	}

	@Override
	public List<Consignee> getConsigneeByUsername(String username) {
		// TODO Auto-generated method stub
		return consigneeDao.getConsigneeByUsername(username);
	}

	@Override
	public boolean addConsignee(Consignee consignee) {
		// TODO Auto-generated method stub
		return consigneeDao.addConsignee(consignee);
	}

	@Override
	public boolean deleteConsignee(int id) {
		// TODO Auto-generated method stub
		return consigneeDao.deleteConsignee(id);
	}

	@Override
	public boolean updateConsignee(Consignee consignee) {
		// TODO Auto-generated method stub
		return consigneeDao.updateConsignee(consignee);
	}

	@Override
	public Consignee getConsigneeById(int consigneeid) {
		// TODO Auto-generated method stub
		return consigneeDao.getConsigneeById(consigneeid);
	}

}
