package com.project.pagination.exception;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


public class CustomException extends RuntimeException{

    private final String customMessage;

    private final HttpStatus httpStatus;

    private Exception exception;

    public CustomException(String customMessage, HttpStatus httpStatus){
        super();
        this.customMessage=customMessage;
        this.httpStatus=httpStatus;
    }

    public CustomException(String customMessage, HttpStatus httpStatus, Exception exception){
        super();
        this.customMessage=customMessage;
        this.httpStatus=httpStatus;
        this.exception=exception;
    }
}
