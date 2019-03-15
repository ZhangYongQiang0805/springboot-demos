package com.zyq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyq.bean.Account;
import com.zyq.dao.IAccountDAO;

@Service
public class AccountService implements IAccountService {
	@Autowired
	IAccountDAO accountDAO;

	@Override
	public int add(Account account) {
		return accountDAO.add(account);
	}

	@Override
	public int update(Account account) {
		return accountDAO.update(account);
	}

	@Override
	public int delete(int id) {
		return accountDAO.delete(id);
	}

	@Override
	public Account findAccountById(int id) {
		return accountDAO.findAccountById(id);
	}

	@Override
	public List<Account> findAccountList() {
		return accountDAO.findAccountList();
	}
}
