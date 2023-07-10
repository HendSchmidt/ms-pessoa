package br.com.estudo.pessoas.microservico.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        String mensagem = "Ocorreu uma RuntimeException: " + ex.getMessage();
        return new ResponseEntity<>(mensagem, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

