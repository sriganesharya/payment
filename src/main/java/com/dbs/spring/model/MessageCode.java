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
public class MessageCode {

	@Id
	@Column(length = 4)
	//@OneToMany
	private String messagecode;
	private String instruction;
	
	public MessageCode() {
		// TODO Auto-generated constructor stub
	}
	
}
