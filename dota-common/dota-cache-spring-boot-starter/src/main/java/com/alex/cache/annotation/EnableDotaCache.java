package com.alex.cache.annotation;

import com.alex.cache.config.CacheImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @className EnableDotaCache.java
 * @author: yz
 * @date: 2021/5/13 18:54
 * @version 1.0.0
 * @since 1.1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({CacheImportSelector.class})
public @interface EnableDotaCache {


}
