package com.book.booksstore.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.book.booksstore")
public class AppConfig {
    private final Environment environment;

    @Autowired
    public AppConfig(final Environment env) {
        this.environment = env;
    }

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty(
                "spring.datasource.driverClassName")
        );
        dataSource.setUrl(environment.getProperty(
                "spring.datasource.url")
        );
        dataSource.setUsername(environment.getProperty(
                "spring.datasource.username")
        );
        dataSource.setPassword(environment.getProperty(
                "spring.datasource.password")
        );
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean entityManagerFactory() {
        LocalSessionFactoryBean localSessionFactoryBean =
                new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(getDataSource());

        Properties properties = new Properties();
        properties.put(
                "spring.jpa.hibernate.ddl-auto",
                environment.getProperty("spring.jpa.hibernate.ddl-auto")
        );
        properties.put(
                "spring.jpa.properties.hibernate.dialect",
                environment.getProperty(
                        "spring.jpa.properties.hibernate.dialect")
        );
        localSessionFactoryBean.setHibernateProperties(properties);

        localSessionFactoryBean.setPackagesToScan("com.book.booksstore.model");
        return localSessionFactoryBean;
    }
}
