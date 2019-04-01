package com.zyq.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zyq.bean.UserInfo;
import com.zyq.dao.UserInfoDao;
import com.zyq.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Resource
	private UserInfoDao userInfoDao;

	@Override
	public UserInfo findByUsername(String username) {
		System.out.println("UserInfoServiceImpl.findByUsername()");
		return userInfoDao.findByUsername(username);
	}
}
