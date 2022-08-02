package com.dbs.spring.service;

import java.util.List;


import com.dbs.spring.model.Customers;

public interface CustomerServiceInterface {
	public List<Customers> getCustomerData();
	public boolean insertCustomer(Customers customer);
	public boolean updateCustomer(Customers customer);
	public boolean deleteCustomerById(String id);
	public Customers getCustomerById(String id);
	
}
