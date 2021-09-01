package com.comin.idmanager.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.comin.idmanager.config.interceptors.AuthInterceptor;

@Configuration
public class WebConfiguration implements WebMvcConfigurer{

	private static final Logger logger = LoggerFactory.getLogger(WebConfiguration.class);

	@Autowired
	private AuthInterceptor interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		logger.info("Set Interceptor {}", interceptor.getClass());

		List<String> excludeList = new ArrayList<String>();
		excludeList.add("/admin/**");
		excludeList.add("/err/**");

		registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(excludeList);
	}
}