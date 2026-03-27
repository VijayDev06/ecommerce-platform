package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dto.ErrorHandlingResponse;

@RestControllerAdvice
public class GlobalExceptions {
	
	@ExceptionHandler(ResourceFoundException.class)
	private ResponseEntity<ErrorHandlingResponse> handleAllErrors(ResourceFoundException re) {
		
		 return new ResponseEntity<>(ErrorHandlingResponse.builder().msg(re.getMessage())
				 .build(), HttpStatus.CONFLICT);  // 409 - Duplicate / already exists

	}
}
