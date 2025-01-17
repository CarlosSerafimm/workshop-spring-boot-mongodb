package com.carlos.workshopMongo.service.exception;

public class ObjectNotFoundException extends RuntimeException{
    private static long serialVersionUID = 1L;

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
