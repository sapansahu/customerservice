package com.mustbuy.customerservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerException {
	
	Logger logger = LoggerFactory.getLogger(CustomerException.class);
	
	@ExceptionHandler(Exception.class)
	public void handleGenericException(Exception ex) {
		logger.error(ex.getMessage());
	}
	
}
