package com.dbs.spring.repository;

import org.springframework.data.repository.CrudRepository;


import com.dbs.spring.model.Customers;

public interface CustomerRepository extends CrudRepository<Customers, String> {

}
