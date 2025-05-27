package com.estevao.projetoTesteMongoDB.service.exception;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException(String s) {
        super(s);
    }
}
