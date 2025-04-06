package com.devluis.desafioTransferenciaSimples.exeptions;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handeIllegalArgumentException(IllegalArgumentException e){
        return new ResponseEntity<>("Erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handeBadRequestException(BadRequestException e){
        return new ResponseEntity<>("Erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFound e){
        return new ResponseEntity<>("Erro: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> handleFeignException(FeignException e){
        return new ResponseEntity<>("Erro: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}