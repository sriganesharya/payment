package com.dbs.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.model.Employee;
import com.dbs.spring.service.interfaces.EmployeeServiceInterface;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceInterface employeeService;

	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/signup")
	public String insertEmployee(@RequestBody Employee employee) {
		if(employeeService.insertEmployee(employee)) return "values inserted successfully";
		return "values could not be inserted as the employee already exists";
	}
	
	
}
