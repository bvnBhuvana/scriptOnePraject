package com.slokam.scriptone.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.slokam.scriptone.dto.ErrorResponse;

import com.slokam.scriptone.exception.ApplicationException;
import com.slokam.scriptone.exception.DataNotFoundException;
import com.slokam.scriptone.exception.UserInputException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	
	@ExceptionHandler(UserInputException.class)
	public ResponseEntity<ErrorResponse> handleUserInputException(UserInputException exception){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorResponseCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException exception){
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorResponseCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(ApplicationException exception){
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setMessage(exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleDataNotFoundException(DataNotFoundException exception){
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorResponseCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
	

}
