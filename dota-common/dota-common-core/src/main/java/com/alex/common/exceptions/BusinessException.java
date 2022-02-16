package com.alex.common.exceptions;

import lombok.Getter;

/**
 * 业务异常
 */
@Getter
public class BusinessException extends RuntimeException{

    private final String errorMsg;

    private  int exceptionCode;

    public BusinessException (String errorMsg){
        super(errorMsg);
        this.errorMsg = errorMsg;
    }
}
