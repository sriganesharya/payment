package com.dbs.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.model.Transaction;
import com.dbs.spring.service.interfaces.TransactionServiceInterface;

@CrossOrigin
@RestController
public class TransactionController {
	
	@Autowired
	private TransactionServiceInterface transactionService;

	public TransactionController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/transaction")
	public String insertTransaction(@RequestBody Transaction t) {
		//System.out.println(t);
		return transactionService.insertTransaction(t);
	}
	
	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>> showTransactions() {
		return ResponseEntity.ok(transactionService.showTransactions());
	}
	
	@GetMapping("/transactions/{id}")
	public Transaction getTransactionById(@PathVariable("id") Integer id) {
		try {
			return transactionService.getTransactionById(id);
		}catch (Exception e) {
			System.out.println("transaction id doesn't exist");
			return null;
		}
	}
}
