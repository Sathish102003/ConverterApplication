package com.convert.persistence.configuration;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration
 */
@Configuration
@EnableTransactionManagement
public class JpaConfiguration {

    @Resource
    private DataSource convertDataSource;

    @Bean
    public LocalContainerEntityManagerFactoryBean convertEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceXmlLocation("classpath*:META-INF/jpa-persistence.xml");
        entityManagerFactoryBean.setDataSource(convertDataSource);
        entityManagerFactoryBean.setJpaDialect(new HibernateJpaDialect());
        entityManagerFactoryBean.setJpaVendorAdapter(getHibernateJPAVendorAdapter());
        entityManagerFactoryBean.setPersistenceUnitName("convertPersistenceUnit");
        entityManagerFactoryBean.setJpaProperties(getJPaProperties());
        return entityManagerFactoryBean;
    }

    private Properties getJPaProperties() {
        Properties props = new Properties();
        props.put("hibernate.enable_lazy_load_no_trans", Boolean.TRUE);
        return props;
    }

    private HibernateJpaVendorAdapter getHibernateJPAVendorAdapter() {
        final HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(Boolean.FALSE);

        return hibernateJpaVendorAdapter;
    }

    @Bean
    public JpaTransactionManager convertTxManager() {
        final JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(convertEntityManagerFactory().getObject());
        jpaTransactionManager.setDataSource(convertDataSource);
        return jpaTransactionManager;
    }
}
