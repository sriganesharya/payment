package com.dbs.spring.repository;

import org.springframework.data.repository.CrudRepository;


import com.dbs.spring.model.Banks;

public interface BankRepository extends CrudRepository<Banks, String> {

}
