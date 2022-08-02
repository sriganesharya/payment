package com.dbs.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.model.MessageCode;

public interface MessageRepository extends CrudRepository<MessageCode, String> {

}
