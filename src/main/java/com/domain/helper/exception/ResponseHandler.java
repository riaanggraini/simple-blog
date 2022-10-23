package com.domain.helper.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
public class ResponseHandler {
  public static ResponseEntity<Object> generateResponse(String message, Object data) {
    ResponseFormat respDetail = 
    new ResponseFormat(new Date(), message, null, data);
		return new ResponseEntity<>(respDetail, HttpStatus.OK);
  }
}
