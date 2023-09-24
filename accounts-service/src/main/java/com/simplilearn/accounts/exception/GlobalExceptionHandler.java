package com.simplilearn.accounts.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	ExceptionResponse response;
	
	@ExceptionHandler(value=AccountNotFound.class)
	public ResponseEntity<ExceptionResponse> notFountException(AccountNotFound exception) {
		response = new ExceptionResponse(exception.getMessage(), HttpStatus.NOT_FOUND.name(), 
				new Date(), exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value=AccountAlreadyExist.class)
	public ResponseEntity<ExceptionResponse> alreadyExistException(AccountAlreadyExist exception) {
		response = new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.name(), 
				new Date(), exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.BAD_REQUEST);
	}
}
