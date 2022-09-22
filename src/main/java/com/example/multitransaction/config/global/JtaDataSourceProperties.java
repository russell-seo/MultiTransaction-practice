package com.example.multitransaction.config.global;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
public class JtaDataSourceProperties {

    @Bean(name = "jtaAdminDataSource")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.jtaadmin")
    public DataSource jtaAdminDataSource(){
        return new AtomikosDataSourceBean();
    }

    @Bean(name = "jtaAdminTxManager")
    public PlatformTransactionManager jtaAdminTxManager(){
        return new DataSourceTransactionManager(jtaAdminDataSource());
    }


    @Bean(name = "jtaGameDataSource")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.jtagame")
    public DataSource jtdGameDataSource(){
        return new AtomikosDataSourceBean();
    }

    @Bean(name = "jtaGameTxManager")
    public PlatformTransactionManager jtaGameTxManager(){
        return new DataSourceTransactionManager(jtdGameDataSource());
    }
}
