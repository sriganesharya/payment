package com.dbs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dbs.spring.repository.CustomerRepository;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;

	public CustomerController() {
		// TODO Auto-generated constructor stub
	}

	
}
