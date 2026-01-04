package com.shop.Workshop.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
