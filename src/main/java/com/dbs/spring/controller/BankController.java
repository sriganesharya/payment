package com.dbs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dbs.spring.repository.BankRepository;

@Controller
public class BankController {
	
	@Autowired
	private BankRepository bankRepository;

	public BankController() {
		// TODO Auto-generated constructor stub
	}

}
