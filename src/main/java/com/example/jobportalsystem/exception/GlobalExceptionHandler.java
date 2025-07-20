package com.example.jobportalsystem.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
    @RestControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(RuntimeException.class)
        public ResponseEntity<Map<String, Object>> handleResourceNotFound(RuntimeException ex) {
            Map<String, Object> body = new HashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("message", ex.getMessage());
            body.put("status", HttpStatus.NOT_FOUND.value());

            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
    }

