package com.dbs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dbs.spring.repository.TransferTypesRepository;

@Controller
public class TransferTypesController {

	@Autowired
	private TransferTypesRepository transferTypesRepository;
	
	public TransferTypesController() {
		// TODO Auto-generated constructor stub
	}

}
