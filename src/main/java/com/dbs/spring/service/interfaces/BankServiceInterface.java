package com.dbs.spring.service.interfaces;

import com.dbs.spring.model.Banks;

public interface BankServiceInterface {

	public Banks fetchByBic(String bic);
}
