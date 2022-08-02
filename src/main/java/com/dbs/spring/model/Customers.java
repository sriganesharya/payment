package com.dbs.spring.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Customers {
	
	@Id
	@Column(nullable = false, length = 14)
	private String customerid;
	private String accountholdername;
	private boolean overdraftflag;
	private double clearbalance;
	private String customeraddress;
	private String customercity;
	private String customertype; 

	public Customers() {
		// TODO Auto-generated constructor stub
	}
		
}
