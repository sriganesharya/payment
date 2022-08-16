package com.dbs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.dbs.spring.service.interfaces.ReceiverValidationInterface;

@CrossOrigin("*")
@RestController
public class ReceiverValidationController {

	@Autowired
	private ReceiverValidationInterface receiverValidationService;
	
	//getting the data from front end
	@GetMapping("accountholdername/{receivername}")
	public ResponseEntity<String> isReceiverPresent(@PathVariable("receivername") String receiverName) {
		//calling the search method in the service class
		return receiverValidationService.searchReceiver(receiverName) ? ResponseEntity.ok().body("Transaction Blocked") : ResponseEntity.ok().body("Transaction Allowed");
	}
	
}
