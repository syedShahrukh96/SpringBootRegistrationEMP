package com.shahrukh.advice;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shahrukh.exception.AlreadyExistException;
import com.shahrukh.exception.NoSuchElementException;
import com.shahrukh.response.ErrorMapResponse;
import com.shahrukh.response.ErrorResponse;

@RestControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse NoSuchEltExp(NoSuchElementException ex) {
		
		return new ErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND,
				ex.getMessage());
		
	}
	
	@ExceptionHandler(AlreadyExistException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse AlreadyExistExp(AlreadyExistException al) {
		return new ErrorResponse(
				HttpStatus.CONFLICT.value(),
				HttpStatus.CONFLICT,
				al.getMessage());
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMapResponse MethodArgNotValidExp(MethodArgumentNotValidException al) {
		
		HashMap<String, String> errors = new HashMap<>();
		
		
		al.getBindingResult().getAllErrors().forEach( error -> {
			
			String fname = ((FieldError) error).getField();
			String msg = error.getDefaultMessage();
			
			errors.put(fname, msg);
		});
		
		
		return new ErrorMapResponse(
				HttpStatus.BAD_REQUEST.value(),
				HttpStatus.BAD_REQUEST,
				errors);
		
	}
	
	
	
	
	
	
	
	
	
}
