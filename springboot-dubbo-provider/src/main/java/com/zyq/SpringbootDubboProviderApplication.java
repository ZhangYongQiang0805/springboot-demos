package com.zyq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = { "classpath:dubbo-provider.xml" })
public class SpringbootDubboProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDubboProviderApplication.class, args);
//		try {
			// 加入System.in.read()是起阻塞作用的，否则由于pom中没有加spring-boot-starter-web依赖，启动时没有tomcat容器，会自动退出
			// 阻塞作用，否则会由于不是web项目，执行main方法后立即停止服务。
//			System.in.read();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
