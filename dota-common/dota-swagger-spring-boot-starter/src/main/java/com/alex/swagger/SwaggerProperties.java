package com.alex.swagger;

import io.swagger.models.Contact;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @version 1.0.0
 * @className SwaggerProperties.java
 * @author: yz
 * @date: 2021/5/22 10:34
 */
@Data
@ConfigurationProperties(prefix = "dota.swagger")
public class SwaggerProperties {

    private String title;
    private String description;
    private String termsOfServiceUrl;
    private String name;
    private String url;
    private String email;
    private String license;
    private String licenseUrl;
    private String version;

    private List<String> packages;
}
