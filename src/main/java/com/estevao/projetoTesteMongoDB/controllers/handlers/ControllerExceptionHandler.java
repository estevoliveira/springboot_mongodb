package com.estevao.projetoTesteMongoDB.controllers.handlers;

import com.estevao.projetoTesteMongoDB.models.dto.CustomErrorDTO;
import com.estevao.projetoTesteMongoDB.service.exception.NotFoundUserException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<CustomErrorDTO> resourceNotFound(NotFoundUserException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomErrorDTO err = new CustomErrorDTO(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
