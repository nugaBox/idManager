package com.comin.idmanager.error;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
	private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

	@RequestMapping(value="/err/{errorCode}", method={RequestMethod.POST})
	@ResponseBody
	public String errMessage(@PathVariable("errorCode") String errorCode, HttpServletRequest request) throws Exception {
		logger.info("Error Handle... {}", errorCode);

		JSONObject jsonObj = new JSONObject();

		jsonObj.put("success", false);
		jsonObj.put("code", errorCode);

		return jsonObj.toString(4);
	}
}
