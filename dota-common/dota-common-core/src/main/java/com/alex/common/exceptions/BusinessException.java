package com.alex.common.exceptions;

public class BusinessException extends RuntimeException{

    private String errorMsg;

    public BusinessException (String errorMsg){
        this.errorMsg = errorMsg;
    }
}
