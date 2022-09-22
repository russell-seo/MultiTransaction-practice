package com.example.multitransaction.config.global;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.example.multitransaction.mapper.globalGame"}, sqlSessionFactoryRef = "jtaGameSqlSessionFactory")
public class GlobalGameTransactionConfig {

    @Bean(name ="jtaGameSqlSessionFactory")
    public SqlSessionFactory jtaGameSqlSessionFactory(@Qualifier("jtaGameDataSource")DataSource jtaGameDataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(jtaGameDataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "jtaGameSqlSessionTemplate")
    public SqlSessionTemplate jtaGameSqlSessionTemplate(SqlSessionFactory jtaGameSqlSessionFactory){
        return new SqlSessionTemplate(jtaGameSqlSessionFactory);
    }
}
