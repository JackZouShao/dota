package com.alex.auth.controller;

import com.alex.common.exceptions.BusinessException;
import com.alex.common.util.RJson;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(value = "com.alex.auth.controller")
public class ControllerAdv {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = BusinessException.class)
    public RJson handleBusinessException(BusinessException businessException){
        return  RJson.failed(businessException.getMessage(), businessException.getExceptionCode());
    }
}
