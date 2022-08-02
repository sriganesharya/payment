package com.dbs.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Banks {
	
	@Id
	@Column(length = 11)
	private String bic;
	private String bankname;

	public Banks() {
		// TODO Auto-generated constructor stub
	}

	
}
