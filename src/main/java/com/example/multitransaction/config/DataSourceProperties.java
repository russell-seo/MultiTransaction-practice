package com.example.multitransaction.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
public class DataSourceProperties {

    @Bean(name = "adminDataSource")
//    @Primary
    @Qualifier("adminDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.admin")
    public DataSource adminDataSource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "adminTxManager")
    public PlatformTransactionManager adminTxManager(){
        return new DataSourceTransactionManager(adminDataSource());
    }

    @Bean(name = "gameDataSource")
    @Qualifier("gameDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.game")
    public DataSource gameDataSource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "gameTxManager")
    public PlatformTransactionManager gameTxManager(){
        return new DataSourceTransactionManager(gameDataSource());
    }
}


