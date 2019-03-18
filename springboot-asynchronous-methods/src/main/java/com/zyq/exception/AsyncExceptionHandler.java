package com.zyq.exception;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

/**
 * 异步异常处理类
 */
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(AsyncExceptionHandler.class);

	@Override
	public void handleUncaughtException(Throwable ex, Method method, Object... params) {
		if (ex instanceof AsyncException) {
			AsyncException asyncException = (AsyncException) ex;
			logger.info("asyncException:{}", asyncException.getErrorMessage());
		}
		logger.info("Exception :");
		ex.printStackTrace();
	}

}
