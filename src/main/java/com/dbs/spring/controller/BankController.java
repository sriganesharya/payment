package com.dbs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.model.Banks;
import com.dbs.spring.service.interfaces.BankServiceInterface;

@CrossOrigin
@RestController
public class BankController {
	
	@Autowired
	private BankServiceInterface bankService;

	@GetMapping("/bank/{bic}")
	public Banks fetchBank(@PathVariable("bic") String bic) {
		try {
			return bankService.fetchByBic(bic);
		}catch (Exception e) {
			System.out.println("Bank with the given bic doesn't exist");
			return null;
		}
		
	}

}
