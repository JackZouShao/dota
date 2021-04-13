package com.alex.common.advice;

import com.alex.common.exceptions.BusinessException;
import com.alex.common.util.RJson;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(value = "com.alex")
public class ControllerAdvice {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = BusinessException.class)
    public RJson handleBusinessException(BusinessException businessException){
        System.out.println("Controller Advice");
        return  RJson.failed(businessException.getMessage(), businessException.getExceptionCode());
    }
}
