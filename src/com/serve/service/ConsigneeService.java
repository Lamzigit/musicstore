package com.serve.service;

import java.util.List;

import com.serve.entity.Consignee;

public interface ConsigneeService {
	
	 public List<Consignee> getConsigneeList();
	 
	 public List<Consignee> getConsigneeByUsername(String username);
	 
	 public Consignee getConsigneeById(int consigneeid);
	 
	 public boolean addConsignee(Consignee consignee);
	 
	 public boolean deleteConsignee(int id);
	 
	 public boolean updateConsignee(Consignee consignee);
}
