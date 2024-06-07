package com.example.sprint2.exp;

import com.example.sprint2.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CustomException {
    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<?> ExceptionForAll(BaseException e) {
        ApiError apiError = new ApiError(e.getMessage(), e, HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}