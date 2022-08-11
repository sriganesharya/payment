package com.dbs.spring.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.Banks;
import com.dbs.spring.repository.BankRepository;
import com.dbs.spring.service.interfaces.BankServiceInterface;

@Service
public class BankSevice implements BankServiceInterface {
	
	@Autowired
	private BankRepository bankRepository;
	
	@Override
	public Banks fetchByBic(String bic) {
		try {
			return bankRepository.findById(bic).orElseThrow(()->{
				System.out.println("Error finding bank in database");
				return new EntityNotFoundException("Bank with "+bic+" does not exist");
			});
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
