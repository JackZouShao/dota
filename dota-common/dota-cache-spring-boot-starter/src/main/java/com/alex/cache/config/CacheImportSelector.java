package com.alex.cache.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * @version 1.0.0
 * @className CacheImportSelector.java
 * @author: yz
 * @date: 2021/5/14 14:31
 */
public class CacheImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        annotationTypes.forEach(System.out::println);
        return new String[]{
                CacheConfiguration.class.getName()
        };
    }
}
