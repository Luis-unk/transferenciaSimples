package com.devluis.desafioTransferenciaSimples.exeptions;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message) {
        super(message);
    }

}
