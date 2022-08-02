package com.dbs.spring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.model.Customers;
import com.dbs.spring.repository.CustomerRepository;

@Service
public class CustomerService implements CustomerServiceInterface{
	
	@Autowired
	private CustomerRepository customerRepository;

	public boolean insertCustomer(Customers customer) {
		if(this.customerRepository.findById(customer.getCustomerid()).isPresent())
			return false;
		else {
			try {
				this.customerRepository.save(customer);
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				return false;
			}
		}
		return true;
	}

	@Override
	public List<Customers> getCustomerData() {
		// TODO Auto-generated method stub
		return (List<Customers>) customerRepository.findAll();
	}

	@Override
	public boolean updateCustomer(Customers customer) {
		// TODO Auto-generated method stub
		try {
			customerRepository.save(customer);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCustomerById(String id) {
		try {
			Customers customer = getCustomerById(id);
			this.customerRepository.delete(customer);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Customers getCustomerById(String id) {
		// TODO Auto-generated method stub
		try {
			Optional<Customers> customer = this.customerRepository.findById(id);
	        return customer.orElseThrow(()->{
	            System.out.println("Error Finding customer in database");
	            return new EntityNotFoundException("Customer with "+id + " does not exist");
	        });
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}	
	}
}
