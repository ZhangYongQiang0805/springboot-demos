package com.zyq;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.zyq.exception.AsyncExceptionHandler;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
// 实现AsyncConfigurer接口，也可以继承AsyncConfigurerSupport类来实现
public class AsynchronousMethodsApplication extends AsyncConfigurerSupport {

	public static void main(String[] args) {
		SpringApplication.run(AsynchronousMethodsApplication.class, args);
	}

	@Override
	public Executor getAsyncExecutor() {
		/**
		 * 在方法getAsyncExecutor()中创建线程池的时候，必须使用
		 * executor.initialize()，不然在调用时会报线程池未初始化的异常。
		 * 如果使用threadPoolTaskExecutor()来定义bean，则不需要初始化
		 */
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(3);
		executor.setMaxPoolSize(3);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("GithubLookup-");
		executor.initialize();// 如果不初始化，导致找到不到执行器
		return executor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new AsyncExceptionHandler();
	}

}
