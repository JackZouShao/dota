package com.alex.cache.manager;

import com.alex.cache.CacheUtils;
import com.alex.cache.annotation.CacheGet;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StringUtils;

/**
 * @version 1.0.0
 * @className CacheGetOperation.java
 * @author: yz
 * @date: 2021/5/13 20:12
 */
@Slf4j
public class CacheGetOperation implements CacheOperation {

    @Override
    public Object cache(JoinPoint joinPoint) {
        var proceedingJoinPoint = (ProceedingJoinPoint) joinPoint.getSignature();
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        var method = signature.getMethod();

        Class<?> returnType = method.getReturnType();
        CacheGet annotation = method.getAnnotation(CacheGet.class);
        var annotationParam = getParam(annotation);
        String key = CacheUtils.parseSpel(method, proceedingJoinPoint.getArgs(), annotationParam.getKey(), String.class, "");
        annotationParam.setCacheKey(key);
        // TODO Cache.getValue();
        var value = "";
        Object result;
        if(!StringUtils.isEmpty(value)){
           return JSON.parseObject(value, returnType);
        }

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.error("缓存被代理方法: {} , 执行报错: {}", method.getName(), throwable.getMessage());
            throw new IllegalStateException(throwable.getMessage());
        }
        return result;
    }

    private AnnotationParam getParam(CacheGet annotation){
        return AnnotationParam.builder()
                .prefix(annotation.prefix())
                .key(annotation.key())
                .expireTime(annotation.expireTime())
                .timeUnit(annotation.timeUnit())
                .dataType(annotation.cacheType())
                .hashKey(annotation.hashKey())
                .build();
    }
}
