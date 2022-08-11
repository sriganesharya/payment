package com.dbs.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.Logger;
import com.dbs.spring.repository.LoggerRepository;
import com.dbs.spring.service.interfaces.LoggerServiceInterface;

@Service
public class LoggerService implements LoggerServiceInterface {
	
	@Autowired
	private LoggerRepository loggerRepository;

	
	@Override
	public boolean insertLogger(Logger lg) {
		if(loggerRepository.findById(lg.getLoggerid()).isPresent()) return false;
		try {
			loggerRepository.save(lg);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean updateLogger(Logger lg) {
		try {
			if(loggerRepository.findById(lg.getLoggerid()).isPresent()) loggerRepository.save(lg);
			else return false;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteLoggerById(Integer id) {
		// TODO Auto-generated method stub
		if(loggerRepository.findById(id).isPresent())loggerRepository.deleteById(id);
		else return false;
		return true;
	}

	@Override
	public List<Logger> getLoggers() {
		// TODO Auto-generated method stub
		List<Logger> loggers = new ArrayList<>();
		loggerRepository.findAll().forEach(lg->loggers.add(lg));
		return loggers;
	}

	@Override
	public Logger getLoggerById(Integer id) {
		// TODO Auto-generated method stub
		return loggerRepository.findById(id).orElse(null);
	}

}
