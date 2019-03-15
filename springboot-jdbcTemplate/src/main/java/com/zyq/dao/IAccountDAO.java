package com.zyq.dao;

import java.util.List;

import com.zyq.bean.Account;

public interface IAccountDAO {

	int add(Account account);

	int update(Account account);

	int delete(int id);

	Account findAccountById(int id);

	List<Account> findAccountList();

}
