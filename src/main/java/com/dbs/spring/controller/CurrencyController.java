package com.dbs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dbs.spring.repository.CurrencyRepository;

@Controller
public class CurrencyController {
	
	@Autowired
	private CurrencyRepository currencyRepository;

	public CurrencyController() {
		// TODO Auto-generated constructor stub
	}

}
