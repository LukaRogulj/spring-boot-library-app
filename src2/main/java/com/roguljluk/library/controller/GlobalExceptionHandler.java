package com.roguljluk.library.controller;

import com.roguljluk.library.exception.AuthorCreationException;
import com.roguljluk.library.exception.BookLoanException;
import com.roguljluk.library.exception.UserCreationException;
import com.roguljluk.library.model.dto.ApiErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        return ResponseEntity
                .status(httpStatus)
                .body(new ApiErrorResponse(httpStatus.value(), ex.getMessage(), request.getContextPath()));
    }

    @ExceptionHandler(AuthorCreationException.class)
    public ResponseEntity<ApiErrorResponse> handleAuthorCreationException(AuthorCreationException ex, HttpServletRequest request){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        return ResponseEntity
                .status(httpStatus)
                .body(new ApiErrorResponse(httpStatus.value(), ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(UserCreationException.class)
    public ResponseEntity<ApiErrorResponse> handleUserCreationException(UserCreationException ex, HttpServletRequest request){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        return ResponseEntity
                .status(httpStatus)
                .body(new ApiErrorResponse(httpStatus.value(), ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(BookLoanException.class)
    public ResponseEntity<ApiErrorResponse> handleBookLoanException(BookLoanException ex, HttpServletRequest request){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        return ResponseEntity
                .status(httpStatus)
                .body(new ApiErrorResponse(httpStatus.value(), ex.getMessage(), request.getRequestURI()));
    }
}
