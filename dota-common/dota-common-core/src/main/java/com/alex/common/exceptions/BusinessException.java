package com.alex.common.exceptions;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{

    private String errorMsg;

    private  int exceptionCode;

    public BusinessException (String errorMsg){
        super(errorMsg);
        this.errorMsg = errorMsg;
    }
}
