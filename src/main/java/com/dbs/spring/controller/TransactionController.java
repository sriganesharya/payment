package com.dbs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dbs.spring.repository.TransactionRepository;

@Controller
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;

	public TransactionController() {
		// TODO Auto-generated constructor stub
	}

}
