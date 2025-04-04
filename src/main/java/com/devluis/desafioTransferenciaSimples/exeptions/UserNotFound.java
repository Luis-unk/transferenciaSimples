package com.devluis.desafioTransferenciaSimples.exeptions;

public class UserNotFound extends RuntimeException{

    public UserNotFound(String message){
        super(message);
    }
}
