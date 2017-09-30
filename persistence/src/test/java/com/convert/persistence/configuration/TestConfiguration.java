package com.convert.persistence.configuration;

/**
 * Test Configuration.
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath*:database-source.xml")
@ComponentScan(basePackages = { "com.convert.persistence" })
public class TestConfiguration {

}
