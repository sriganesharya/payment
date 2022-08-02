package com.dbs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dbs.spring.repository.LoggerRepository;

@Controller
public class LoggerController {
	
	@Autowired
	private LoggerRepository loggerRepository;

	public LoggerController() {
		// TODO Auto-generated constructor stub
	}

}
