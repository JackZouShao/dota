package com.alex.cache.operation;

import com.alex.cache.CacheUtils;
import com.alex.cache.annotation.CacheInvalidate;
import com.alex.cache.manager.AnnotationParam;
import com.alex.cache.manager.Cache;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import javax.annotation.Resource;

/**
 * @version 1.0.0
 * @className CacheInvalidateOperation.java
 * @author: yz
 * @date: 2021/5/14 14:03
 */
@Slf4j
public class CacheInvalidateOperation implements CacheOperation {

    @Resource
    private Cache cache;

    @Override
    public Object cache(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        var method = signature.getMethod();
        CacheInvalidate annotation = method.getAnnotation(CacheInvalidate.class);

        var annotationParam = getParam(annotation);
        String key = CacheUtils.parseSpel(method, joinPoint.getArgs(), annotationParam.getKey(), String.class, "");
        annotationParam.setCacheKey(key);

        cache.invalidate(key);
        return null;
    }

    private AnnotationParam getParam(CacheInvalidate annotation){
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
