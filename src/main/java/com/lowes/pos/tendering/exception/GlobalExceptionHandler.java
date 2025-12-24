package com.lowes.pos.tendering.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebInputException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getBindingResult().getAllErrors());
    }

    @ExceptionHandler(ServerWebInputException.class)
    public ResponseEntity<?> handleWebFlux(ServerWebInputException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getReason());
    }
}
