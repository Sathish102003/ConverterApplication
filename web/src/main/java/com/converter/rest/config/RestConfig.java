package com.converter.rest.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * ClientConfig.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "com.convert.service",
        "com.converter.domain",
        "com.converter.rest",
        "com.converter.business" })
public class RestConfig {

    private static final String PROPERTY_FILE = "application.properties";

    @Bean
    public static PropertyPlaceholderConfigurer propertyConfigurer(Environment env) {
        PropertyPlaceholderConfigurer bean = new PropertyPlaceholderConfigurer();
        bean.setLocation(new ClassPathResource(PROPERTY_FILE));
        return bean;
    }

}
