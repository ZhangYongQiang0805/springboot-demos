package com.zyq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyq.bean.Account;
import com.zyq.dao.AccountMapper;

@Service
public class AccountService {
	@Autowired
	private AccountMapper accountMapper;

	public int add(String name, double money) {
		return accountMapper.add(name, money);
	}

	@Transactional // 声明事务,注解开启了事务
	public int update(String name, double money, int id) {
		accountMapper.update(90, 1);// 用户1减10块 用户2加10块
		int i = 1 / 0;
		accountMapper.update(110, 2);
		return i;
	}

	public int delete(int id) {
		return accountMapper.delete(id);
	}

	public Account findAccount(int id) {
		return accountMapper.findAccount(id);
	}

	public List<Account> findAccountList() {
		return accountMapper.findAccountList();
	}
}