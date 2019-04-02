package com.zyq.entity;

import java.io.Serializable;

/**
 * 对象一定要序列化
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String blog;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public User() {
	}

	public User(String name, String blog) {
		super();
		this.name = name;
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", blog=" + blog + "]";
	}

}