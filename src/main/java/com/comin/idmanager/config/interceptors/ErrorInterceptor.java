package com.comin.idmanager.config.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorInterceptor implements ErrorController {

	private static final Logger logger = LoggerFactory.getLogger(ErrorInterceptor.class);

	static final String ERROR_PATH = "/error";

	@Value("${web.path.error}")
	String errorPage;

	@RequestMapping(value = ERROR_PATH)
	public String error(HttpServletRequest request) {
		Object errorStatusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		logger.info("ERROR Interceptor: {}", errorStatusCode);
		return errorPage + errorStatusCode;
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
}
