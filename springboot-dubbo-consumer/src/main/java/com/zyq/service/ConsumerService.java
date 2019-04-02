package com.zyq.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zyq.entity.User;

@Component
public class ConsumerService {

	@Reference(timeout=3000) // 不能在Controller中直接Reference,需要使用Component优先加载Bean，否则会报空指针问题
	UserService userService;

	public List<User> getUsers(String id) {
		return userService.getUsers(id);
	}

}
