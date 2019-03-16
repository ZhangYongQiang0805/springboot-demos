package com.zyq.dao.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.zyq.bean.Account;
import com.zyq.dao.IAccountDAO;

@Component
public class AccountDaoImpl implements IAccountDAO {

	@Override
	@Cacheable("accounts")
	public Account findAccountById(int id) {
		System.out.println("进入dao >>>>>>>>>>>>>>>>>" + id);
		return new Account(id,"Account one",1L);
	}

	
}