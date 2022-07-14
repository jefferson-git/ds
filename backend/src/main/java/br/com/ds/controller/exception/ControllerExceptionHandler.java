package br.com.ds.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(br.com.ds.service.exception.ObjectNotFoundException.class)
	public ResponseEntity<StandarError> ObjectNotFoundException(br.com.ds.service.exception.ObjectNotFoundException ex){
		StandarError erro = new StandarError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
}