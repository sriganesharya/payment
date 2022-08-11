package com.dbs.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.model.Customers;
import com.dbs.spring.service.interfaces.CustomerServiceInterface;

@CrossOrigin
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerServiceInterface customerService;
	

	@GetMapping("/customers/{id}")
	public Customers getCustomerById(@PathVariable("id") String id) {
		try {
			return customerService.getCustomerById(id);
		} catch (Exception e) {
			System.out.println("Customer with the given customer id doesn't exist");
			return null;
		}
	}
	
	@GetMapping("/customers")
	public List<Customers> getCustomers(){
		try {
			return customerService.getCustomerData();
		} catch (Exception e) {
			System.out.println("couln't load customers data");
			return null;
		}
	}
}
