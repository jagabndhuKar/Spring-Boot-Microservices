package com.lcwd.user.service.UserService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.user.service.UserService.Paylod.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerUserNotFoundException(UserNotFoundException exception) {
		String message = exception.getMessage();
		return new ResponseEntity<ApiResponse>(ApiResponse.buildApiResponse(message,true, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
	}
}
