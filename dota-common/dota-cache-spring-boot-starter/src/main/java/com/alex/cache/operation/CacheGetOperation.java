package com.alex.cache.operation;

import com.alex.cache.CacheUtils;
import com.alex.cache.annotation.CacheGet;
import com.alex.cache.manager.AnnotationParam;
import com.alex.cache.manager.Cache;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @version 1.0.0
 * @className CacheGetOperation.java
 * @author: yz
 * @date: 2021/5/13 20:12
 */
@Slf4j
public class CacheGetOperation implements CacheOperation {

    @Resource
    private Cache cache;

    @Override
    public Object cache(JoinPoint joinPoint) {
        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) joinPoint;
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        var method = signature.getMethod();

        Class<?> returnType = method.getReturnType();
        CacheGet annotation = method.getAnnotation(CacheGet.class);

        var annotationParam = getParam(annotation);
        String key = CacheUtils.parseSpel(method, proceedingJoinPoint.getArgs(), annotationParam.getKey(), String.class, "");
        key = annotationParam.setCacheKey(key);

        Object result = cache.get(key, returnType);
        if(!Objects.isNull(result)){
            return result;
        }

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.error("缓存被代理方法: {} , 执行报错: {}", method.getName(), throwable.getMessage());
            throw new IllegalStateException(throwable.getMessage());
        }

        cache.set(key, result, annotationParam.getExpireTime(), annotationParam.getTimeUnit());
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
