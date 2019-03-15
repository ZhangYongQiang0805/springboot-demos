package com.zyq.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyq.bean.ConfigBean;
import com.zyq.bean.User;

@RestController
@EnableConfigurationProperties({ ConfigBean.class, User.class })
public class ConfigController {

	@Value("${my.name}")
	private String name;
	@Value("${my.age}")
	private int age;

	@RequestMapping(value = "/")
	public String getConfig() {
		return name + " >>> " + age;
	}

	@Autowired
	ConfigBean configBean;

	@RequestMapping(value = "/config")
	public String getConfigBean() {
		return configBean.toString();
	}

	@Autowired
	User user;

	@RequestMapping(value = "/user")
	public String user() {
		return user.getName() + " >>>>" + user.getAge();
	}

}
