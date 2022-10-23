package com.domain.helper.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	// handling specific exception
	@ExceptionHandler(NotfoundException.class)
	public ResponseEntity<?> resourceNotFoundHandling(NotfoundException exception, WebRequest request){
		ResponseFormat errorDetails = 
				new ResponseFormat(new Date(), exception.getMessage(), request.getDescription(false), null);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicateException.class)
	public ResponseEntity<?> duplicateExceptionHHandling(DuplicateException exception, WebRequest request){
		ResponseFormat errorDetails = 
				new ResponseFormat(new Date(), exception.getMessage(), request.getDescription(false), null);
		return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<?> unauthorizedExceptionHandling(UnauthorizedException exception, WebRequest request){
		ResponseFormat errorDetails = 
				new ResponseFormat(new Date(), exception.getMessage(), request.getDescription(false), null);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	// handling global exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
		ResponseFormat errorDetails = 
				new ResponseFormat(new Date(), exception.getMessage(), request.getDescription(false), null);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}