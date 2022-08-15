package com.dbs.spring.model;

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
public class Transfertype {
	
	@Id
	private String transfercode;
	private String transferdescription;
	
	public Transfertype() {
		// TODO Auto-generated constructor stub
	}

}
