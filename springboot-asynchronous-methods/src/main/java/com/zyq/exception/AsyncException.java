package com.zyq.exception;

/**
 * 异步处理异常类
 */
public class AsyncException extends Exception {
	private static final long serialVersionUID = 1L;
	private int code;
	private String errorMessage;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}