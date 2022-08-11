package com.dbs.spring.service.interfaces;


import java.util.List;

import com.dbs.spring.model.Logger;

public interface LoggerServiceInterface {
	
	public boolean insertLogger(Logger lg);
	
	public boolean updateLogger(Logger lg);
	
	public boolean deleteLoggerById(Integer id);
	
	public List<Logger> getLoggers();
	
	public Logger getLoggerById(Integer id);
}
