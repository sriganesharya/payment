package com.dbs.spring.service;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.Customers;
import com.dbs.spring.model.Logger;
import com.dbs.spring.model.Transaction;
import com.dbs.spring.repository.TransactionRepository;
import com.dbs.spring.service.interfaces.CustomerServiceInterface;
import com.dbs.spring.service.interfaces.LoggerServiceInterface;
import com.dbs.spring.service.interfaces.TransactionServiceInterface;

@Service
public class TransactionService implements TransactionServiceInterface {
	
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private CustomerServiceInterface customerService;
	@Autowired
	private LoggerServiceInterface loggerService;
	
	private Logger logger = new Logger();

	@Override
	public String insertTransaction(Transaction t) {
		String message = "transaction failed";
		try {
			double amount = t.getInrAmount();
			Customers customer = t.getCustomerId();
			boolean overDraft = customer.isOverdraftflag();
			double oldBalance = customer.getClearbalance();
			if(amount < oldBalance || overDraft ) {
				transactionRepository.save(t);
				double newBalance = oldBalance - amount;
				customer.setClearbalance(newBalance);
				if(customerService.updateCustomer(customer)) {
					message = "transaction successful";
					if(!addLogger(t,message)) return "Logger couldn't be inserted";
					else System.out.println("Logger added successfully");
				}
				else {
					return "customer couldn't be updated";
				}
			}
			else {
				addLogger(t,message);
				return "Insufficient Balance";
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "Transaction couldn't be processed";
		}
		
		return "Transaction Successful";
	}
	
	private boolean addLogger( Transaction t, String message) throws Exception
	{
		final InetAddress host;
		try{
			host = InetAddress.getLocalHost();
			logger.setCustomeriD(t.getCustomerId());
			logger.setIpaddress(host.getHostAddress());
			logger.setScreenname(host.getHostName());
			logger.setAction(message);
			if(loggerService.insertLogger(logger)) return true;
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return false;
	}

	@Override
	public List<Transaction> showTransactions() {
		List<Transaction> transactions = new ArrayList<>();		
		transactionRepository.findAll().forEach(t->transactions.add(t));
		return transactions;
	}

	@Override
	public Transaction getTransactionById(Integer id) {
		try {
			return transactionRepository.findById(id).orElseThrow(()->{
	            System.out.println("Error Finding transaction in database");
	            return new EntityNotFoundException("Transaction with "+id + " does not exist");
	        });
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		
	}
	
	
}
