package com.zyq;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.zyq.entity.User;
import com.zyq.service.GitHubLookupService;
import com.zyq.service.NotResultService;

@Component
public class AppRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

	private final GitHubLookupService gitHubLookupService;

	private final NotResultService notResultService;

	public AppRunner(GitHubLookupService gitHubLookupService, NotResultService notResultService) {
		this.gitHubLookupService = gitHubLookupService;
		this.notResultService = notResultService;
	}

	@Override
	public void run(String... args) throws Exception {
		/**
		 * 在无返回值的异步调用中，异步处理抛出异常，AsyncExceptionHandler的handleUncaughtException()
		 * 会捕获指定异常，原有任务还会继续运行，直到结束。
		 * 
		 * 在有返回值的异步调用中，异步处理抛出异常，会直接抛出异常，异步任务结束，原有处理结束执行。
		 */
		/** 无参数返回的 **/
		notResultService.dealNoReturnTask(0);//这里报错不影响其他任务
		notResultService.dealNoReturnTask(1);
		notResultService.dealNoReturnTask(2);

		/** 有参数返回的 **/
		// Start the clock
		long start = System.currentTimeMillis();
		Future<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
		Future<User> page2 = gitHubLookupService.findUser("CloudFoundry");
		Future<User> page3 = gitHubLookupService.findUser("Spring-Projects");
		// Wait until they are all done 等到它们都做完了
		while (!(page1.isDone() && page2.isDone() && page3.isDone())) {
			Thread.sleep(10); // 10-millisecond pause between each check
		}
		// Print results, including elapsed time
		logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
		logger.info("1--> " + page1.get());
		logger.info("2--> " + page2.get());
		logger.info("3--> " + page3.get());
	}

}