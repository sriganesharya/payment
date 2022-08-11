package com.dbs.spring.service.interfaces;

import java.util.List;


import com.dbs.spring.model.Transaction;

public interface TransactionServiceInterface {
	
	public String insertTransaction(Transaction t);
	
	public List<Transaction> showTransactions();
	
	public Transaction getTransactionById(Integer id);
}
