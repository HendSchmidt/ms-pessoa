package br.com.estudo.pessoas.microservico.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.estudo.pessoas.microservico.util.ObjectError;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ObjectError> handleRuntimeException(RuntimeException ex) {
    	ObjectError obj = new ObjectError();
    	obj.setErro(ex.getMessage());
    	
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(obj);
    }
}

