package com.dbs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.service.interfaces.ReceiverValidationInterface;

@RestController
public class ReceiverValidationController {

	@Autowired
	private ReceiverValidationInterface receiverValidationService;
	
	//getting the data from front end
	@PostMapping("/{receivername}")
	boolean isReceiverPresent(@PathVariable("receivername") String receiverName) {
		//calling the search method in the service class
		return receiverValidationService.searchReceiver(receiverName);
	}
	
}
