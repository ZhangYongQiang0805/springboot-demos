package com.zyq.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.zyq.entity.User;
import com.zyq.service.UserService;

@Service
@Component
public class UserServiceImpl implements UserService {

	@Override
	public List<User> getUsers(String id) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello Dubbo " + id);
		User user1 = new User("一", "博客园");
		User user2 = new User("二", "开源社区");
		List<User> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		return list;
	}
}
