package com.zyq.service;

import com.zyq.bean.UserInfo;

public interface UserInfoService {
	
	/**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);

}
