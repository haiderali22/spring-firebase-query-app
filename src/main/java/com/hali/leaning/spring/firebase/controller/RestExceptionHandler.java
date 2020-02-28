package com.hali.leaning.spring.firebase.controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestControllerAdvice
public class RestExceptionHandler 
{
	private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
	
	@ExceptionHandler(value = { HttpRequestMethodNotSupportedException.class })
	public ResponseEntity<?> requestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex)
	{
		logger.error(ex.getMessage(),ex);
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED.value()).body(ex.getMessage());
	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<?> unKnownException(Exception ex)
	{
		logger.error(ex.getMessage(),ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("Internal server erorr");
	}
	
	@ExceptionHandler(value = { IllegalArgumentException.class })
	public ResponseEntity<?> validationException(IllegalArgumentException ex)
	{
		logger.error("IllegalArgument Exception",ex);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(ex.getMessage());
	}
}
