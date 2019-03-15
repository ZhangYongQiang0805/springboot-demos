package com.zyq.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyq.service.AccountService;

@RestController
@RequestMapping("/mybitisXml")
public class MybitisXmlController {

	@Autowired
	AccountService accountService;

	/**
	 * 修改，验证事务是否可用
	 * @param id
	 * @param name
	 * @param money
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name") String name,
			@RequestParam(value = "money") double money) {
		int t = accountService.update(name, money, id);
		if (t == 1) {
			return "success";
		} else {
			return "fail";
		}

	}

}
