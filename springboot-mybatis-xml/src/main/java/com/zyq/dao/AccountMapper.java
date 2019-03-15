package com.zyq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zyq.bean.Account;

@Mapper
public interface AccountMapper {

	int add(@Param("name") String name, @Param("money") double money);

	int update(@Param("money") double money, @Param("id") int id);
	
	int update(@Param("name") String name, @Param("money") double money, @Param("id") int id);

	int delete(int id);

	Account findAccount(@Param("id") int id);

	List<Account> findAccountList();
}