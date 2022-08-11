package com.dbs.spring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.Employee;
import com.dbs.spring.repository.EmployeeRepository;
import com.dbs.spring.service.interfaces.EmployeeServiceInterface;

@Service
public class EmployeeService implements EmployeeServiceInterface {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployeesData() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		if(this.employeeRepository.findById(employee.getEmployeeid()).isPresent())
			return false;
		else {
			try {
				this.employeeRepository.save(employee);
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean updateEmployee( Employee employee) {
		try {
			employeeRepository.save(employee);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteEmployeeById(Integer id) {
		if(this.employeeRepository.findById(id).isPresent())
		{
			try {
				Employee employee = getEmployeeById(id);
				this.employeeRepository.delete(employee);
				return true;
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		return false;
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		try {
			Optional<Employee> employee = this.employeeRepository.findById(id);
	        return employee.orElseThrow(()->{
	            System.out.println("Error Finding employee in database");
	            return new EntityNotFoundException("Employee with "+id + " does not exist");
	        });
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

}
