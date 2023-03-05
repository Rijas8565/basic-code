package com.product.convertor.exception;


import org.springframework.http.HttpStatus;




public class CustomException extends RuntimeException{

    private final String customMessage;

    private final HttpStatus httpStatus;

    private Exception exception;

    public CustomException(String customMessage, HttpStatus httpStatus){
        super();
        this.customMessage=customMessage;
        this.httpStatus=httpStatus;
    }

    public CustomException(String customMessage,HttpStatus httpStatus,Exception exception){
        super();
        this.customMessage=customMessage;
        this.httpStatus=httpStatus;
        this.exception=exception;
    }
}
