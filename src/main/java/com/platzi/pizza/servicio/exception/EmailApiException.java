package com.platzi.pizza.servicio.exception;

public class EmailApiException extends RuntimeException{

    public EmailApiException() {
        super("Error sending e-mail...");
    }
}
