package com.comin.idmanager.config.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	@Value("${auth.secretKey}")
	private String secretKey;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		logger.info("Pre Interceptor {}", request.getContextPath());

		String userSecretKey = request.getParameter("secretKey");
		if( userSecretKey != null && userSecretKey.equals(secretKey)) {
			return true;
		} else {
			//response.sendRedirect(request.getContextPath()+"err/999");
			return false;
		}


	}
}
