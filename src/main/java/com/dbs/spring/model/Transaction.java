package com.dbs.spring.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11)
	private int transactionId;
	@ManyToOne( cascade = CascadeType.REMOVE)
	@JoinColumn(name="customerid")
	private Customers customerId;
	@ManyToOne( cascade = CascadeType.REMOVE)
	@JoinColumn(name="currencycode")
	private Currency currencyCode;
	@ManyToOne( cascade = CascadeType.REMOVE)
	@JoinColumn(name="senderbic")
	private Banks senderBIC;
	@ManyToOne( cascade = CascadeType.REMOVE)
	@JoinColumn(name="receiverbic")
	private Banks receiverBIC;
	@Column(length = 14)
	private String receiverAccountHolderNumber;
	private String receiverAccountHolderName;
	@ManyToOne( cascade = CascadeType.REMOVE)
	@JoinColumn(name = "transfertypecode")
	private Transfertype transferTypeCode;
	@ManyToOne( cascade = CascadeType.REMOVE)
	@JoinColumn(name="messagecode")
	private MessageCode messageCode;
	private double currencyAmount;
	private double transferFees;
	private double inrAmount;
	private String transferDate;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	
}
