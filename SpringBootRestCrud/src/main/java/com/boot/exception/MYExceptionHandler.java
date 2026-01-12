package com.boot.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.boot.response.MyErrorResponse;

@RestControllerAdvice
public class MYExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> userNotFound(UserNotFoundException notFoundException){
		
		
		return new ResponseEntity<MyErrorResponse>(
				             new MyErrorResponse(
				            		 notFoundException.getMessage(), 
				            		 "Working in Process",
				            		 500,
				            		 LocalDateTime.now()),
				                     HttpStatus.INTERNAL_SERVER_ERROR);
	                              }
}
