package com.example.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler{
	
	//hadling specific exception
@SuppressWarnings({ "unchecked", "rawtypes" })
@ExceptionHandler(DuplicateEntryException.class)
public ResponseEntity<?>HandelDuplicateEntryException(DuplicateEntryException exception, WebRequest request){
	
	ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
	return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
}


//hadling specific exception
@SuppressWarnings({ "unchecked", "rawtypes" })
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<?>ResourceNotFoundException(ResourceNotFoundException exception, WebRequest request){

ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
}




}

