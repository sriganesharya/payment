package com.dbs.spring.service;

import java.util.List;


import com.dbs.spring.model.Employee;

public interface EmployeeServiceInterface {
	
	public List<Employee> getEmployeesData();
	public boolean insertEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployeeById(Integer id);
	public Employee getEmployeeById(Integer id);
}
