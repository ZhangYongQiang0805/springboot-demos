package com.zyq.service;

import java.util.List;

import com.zyq.bean.Account;

public interface IAccountService {

	int add(Account account);

	int update(Account account);

	int delete(int id);

	Account findAccountById(int id);

	List<Account> findAccountList();

}
