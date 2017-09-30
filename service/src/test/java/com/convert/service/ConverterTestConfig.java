package com.convert.service;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

/**
 * Facilities Client Test Config
 */
@Configuration
@ComponentScan(basePackages = "com.convert.service")
public class ConverterTestConfig {

   private static final String PROPERTY_FILE = "application.properties";

   @Bean
   public static PropertyPlaceholderConfigurer propertyConfigurer(Environment env) {
      PropertyPlaceholderConfigurer bean = new PropertyPlaceholderConfigurer();
      bean.setLocation(new ClassPathResource(PROPERTY_FILE));
      return bean;
   }

}