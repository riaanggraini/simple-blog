package com.domain.helper.exception;

import java.util.Date;

import org.hibernate.annotations.Any;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ResponseHandler {

	// handling global response
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> ok(Exception exception, WebRequest request, Any data){
		ResponseFormat errorDetails = 
				new ResponseFormat(new Date(), exception.getMessage(), request.getDescription(false), data);
		return new ResponseEntity<>(errorDetails, HttpStatus.OK);
	}
}