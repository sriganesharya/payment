package com.dbs.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Employee {
	
	@Id
	//@OneToMany
	private int employeeid;
	private String employeename;
	private String employeepassword;

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
}
