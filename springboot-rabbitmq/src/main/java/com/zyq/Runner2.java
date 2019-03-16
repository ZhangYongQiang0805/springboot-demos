package com.zyq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=1)
public class Runner2 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>服务启动执行  Runner2 <<<<<<<<<<<<<");
	}

}