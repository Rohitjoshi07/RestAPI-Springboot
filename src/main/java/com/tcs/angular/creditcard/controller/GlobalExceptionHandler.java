package com.tcs.angular.creditcard.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tcs.angular.creditcard.exceptions.EmptyInputException;
import com.tcs.angular.creditcard.exceptions.UserAlreadyExistException;
import com.tcs.angular.creditcard.exceptions.UserNotFound;
import com.tcs.angular.creditcard.exceptions.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmptyInputException.class)
	ResponseEntity<String> handleUserNotFoundException(UserNotFoundException e){
		return new ResponseEntity<String>("The desired username is not present into the system",HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserNotFoundException.class)
	ResponseEntity<String> handleEmptyInputException(EmptyInputException e){
		return new ResponseEntity<String>("One of the field is blank, Please have a look",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = UserAlreadyExistException.class)
	public ResponseEntity<Object>exception(UserAlreadyExistException e)
	{
		return new ResponseEntity<>("User Already Exit",HttpStatus.ALREADY_REPORTED);
	}
	@ExceptionHandler(value = UserNotFound.class)
	public ResponseEntity<Object>exception(UserNotFound e)
	{
		return new ResponseEntity<>("User not found!!",HttpStatus.NOT_FOUND);
	}
}
