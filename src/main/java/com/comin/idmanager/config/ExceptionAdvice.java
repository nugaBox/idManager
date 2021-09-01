package com.comin.idmanager.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 * Controller에서 Exception을 throws 했을 때 처리
 */
@RestControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(HttpServletRequest request
			, HttpServletResponse response
			, Object handler
			, Exception exception) {
		return exception.getMessage();
	}

	@ExceptionHandler(NullPointerException.class)
	public String nullPointHandler(HttpServletRequest request
			, HttpServletResponse response
			, Object handler
			, Exception exception) {
		return exception.getMessage();
	}
}
