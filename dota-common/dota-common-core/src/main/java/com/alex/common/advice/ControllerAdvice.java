package com.alex.common.advice;

import com.alex.common.exceptions.BusinessException;
import com.alex.common.util.RJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 通过继承使用
 */
@Slf4j
@ResponseBody
public class ControllerAdvice {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = BusinessException.class)
    public RJson<String> handleBusinessException(BusinessException businessException){
        return RJson.failed(businessException.getMessage(), businessException.getExceptionCode());
    }
}
