package com.dbs.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.model.Logger;



public interface LoggerRepository extends CrudRepository<Logger, Integer> {

}
