package com.example.multitransaction.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.example.multitransaction.mapper.admin"}, sqlSessionFactoryRef = "adminSqlSessionFactory")
public class DataBaseConfig {

    @Bean(name = "adminSqlSessionFactory")
    @Primary
    public SqlSessionFactory adminSqlSessionFactory(@Qualifier("adminDataSource") DataSource adminDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(adminDataSource);

        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:com/example/multitransaction/mapper/admin/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "adminSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate adminSqlSessionTemplate(SqlSessionFactory adminSqlSessionFactory){
        return new SqlSessionTemplate(adminSqlSessionFactory);
    }

}
