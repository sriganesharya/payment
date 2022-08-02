package com.dbs.spring.model;

import javax.persistence.Column;
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
public class Currency {
	
	@Id
	@Column(length = 3)
	//@OneToMany
	private String currencycode;
	private String currencyname;
	private double conversionrate;

	public Currency() {
		// TODO Auto-generated constructor stub
	}
	
}
