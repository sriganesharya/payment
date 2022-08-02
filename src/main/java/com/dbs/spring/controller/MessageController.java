package com.dbs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dbs.spring.repository.MessageRepository;

@Controller
public class MessageController {

	@Autowired
	private MessageRepository messageRepository;
	
	public MessageController() {
		// TODO Auto-generated constructor stub
	}

}
