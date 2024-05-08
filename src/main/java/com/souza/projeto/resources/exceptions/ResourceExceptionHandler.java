package com.souza.projeto.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.souza.projeto.services.exceptions.DatabaseException;
import com.souza.projeto.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	
	public ResourceExceptionHandler() {
		// TODO Auto-generated constructor stub
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFaund(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not faund: ";
		HttpStatus s = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(),s.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(s).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> dataBase(DatabaseException e, HttpServletRequest request){
		String error = "dataBase Error : ";
		HttpStatus s = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(),s.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(s).body(err);
	}

}
