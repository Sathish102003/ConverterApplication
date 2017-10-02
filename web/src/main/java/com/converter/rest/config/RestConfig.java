package com.converter.rest.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.dbcp.BasicDataSource;
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
        "com.converter.business",
        "com.convert.persistence"
})
public class RestConfig {

    private static final String PROPERTY_FILE = "application.properties";

    @Bean
    public static PropertyPlaceholderConfigurer propertyConfigurer(Environment env) {
        PropertyPlaceholderConfigurer bean = new PropertyPlaceholderConfigurer();
        bean.setLocation(new ClassPathResource(PROPERTY_FILE));
        return bean;
    }

    @Bean
    public BasicDataSource convertDataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setDriverClassName("org.postgresql.Driver");
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

}
