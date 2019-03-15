package com.zyq.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyq.dao.RedisDao;

@RestController
public class RedisController {

	@Autowired
	RedisDao redisDao;

	@RequestMapping("/set")
	public String set() {
		redisDao.setKey("name", "haha");
		redisDao.setKey("age", "11");
		return "success";
	}

	@RequestMapping("/get")
	public String get() {
		return "name:" + redisDao.getValue("name") + ",age:" + redisDao.getValue("age");
	}
}
