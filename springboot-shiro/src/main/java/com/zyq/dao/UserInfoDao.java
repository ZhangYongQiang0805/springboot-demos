package com.zyq.dao;

import org.springframework.data.repository.CrudRepository;

import com.zyq.bean.UserInfo;

public interface UserInfoDao extends CrudRepository<UserInfo, Long> {
	/** 通过username查找用户信息; */
	public UserInfo findByUsername(String username);
}