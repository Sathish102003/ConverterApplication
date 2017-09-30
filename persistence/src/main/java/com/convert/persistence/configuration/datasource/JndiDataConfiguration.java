package com.convert.persistence.configuration.datasource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * JNDI DataSource Configuration
 */
@Component
public class JndiDataConfiguration {

    @Bean
    public DataSource convertDataSource() throws NamingException {
        Context ctx = new InitialContext();
        return (DataSource) ctx.lookup("java:comp/env/jdbc/ConvertDataBase");
    }
}
