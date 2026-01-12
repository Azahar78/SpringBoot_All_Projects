package com.boot.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.boot.entity.MyErrorResponse;

@RestControllerAdvice
public class MyCustomException {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<MyErrorResponse> showException(ProductNotFoundException pnf){
		return new ResponseEntity<MyErrorResponse>
		(new MyErrorResponse
				( new Date(),"Fail",pnf.getMessage(), 500),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
