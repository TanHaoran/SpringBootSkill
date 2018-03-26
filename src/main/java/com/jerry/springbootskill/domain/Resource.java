package com.jerry.springbootskill.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/3/26
 * Time: 10:14
 * Description:
 */
@Configuration
@PropertySource(value = "classpath:resource.properties")
@ConfigurationProperties(prefix = "com.jerry")
@Data
public class Resource {

    private String name;
    private String website;
    private String language;
}
