package com.zyq.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zyq.bean.Account;
import com.zyq.dao.IAccountDAO;

@RestController
@RequestMapping("/cache")
public class CacheController {
	@Autowired
	IAccountDAO accountDAO;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Account getAccountById(@PathVariable("id") int id) {
		return accountDAO.findAccountById(id);
	}

}
