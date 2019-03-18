package com.zyq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotResultService {

	private static final Logger logger = LoggerFactory.getLogger(NotResultService.class);

	@Async
	public void dealNoReturnTask(int i) {
		logger.info("Thread {} deal No Return Task start", Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (i == 0) {
			throw new RuntimeException("this is myExcepiton");
		}
        logger.info("Thread {} deal No Return Task end at {}", Thread.currentThread().getName(), System.currentTimeMillis());
	}

}