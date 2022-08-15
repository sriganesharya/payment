package com.dbs.spring.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Logger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11)
	private int loggerid;
	@ManyToOne( cascade = CascadeType.REMOVE)
	@JoinColumn(name="customerid")
	private Customers customeriD;
	private String screenname;
	private String action;
	private String ipaddress;
	
	public Logger() {
		// TODO Auto-generated constructor stub
	}	
	
}
