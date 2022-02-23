package com.alex.common.advice;

import com.alex.common.exceptions.BusinessException;
import com.alex.common.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 通过继承使用
 */
@Slf4j
@ResponseBody
public class ControllerAdvice {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = BusinessException.class)
    public R<String> handleBusinessException(BusinessException businessException){
        return R.failed(businessException.getMessage(), businessException.getExceptionCode());
    }
}
