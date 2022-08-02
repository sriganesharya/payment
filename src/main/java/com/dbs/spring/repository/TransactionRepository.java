package com.dbs.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
