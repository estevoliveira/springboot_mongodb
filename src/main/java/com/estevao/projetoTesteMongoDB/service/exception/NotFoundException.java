package com.estevao.projetoTesteMongoDB.service.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String s) {
        super(s);
    }
}
