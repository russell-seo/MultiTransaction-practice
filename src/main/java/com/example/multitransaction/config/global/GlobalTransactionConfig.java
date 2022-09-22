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
@MapperScan(basePackages = {"com.example.multitransaction.mapper.globalAdmin"}, sqlSessionFactoryRef = "jtaAdminSqlSessionFactory")
public class GlobalTransactionConfig {

    @Bean(name ="jtaAdminSqlSessionFactory")
    public SqlSessionFactory jtaAdminSqlSessionFactory(@Qualifier("jtaAdminDataSource")DataSource jtaAdminDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(jtaAdminDataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "jtaAdminSqlSessionTemplate")
    public SqlSessionTemplate jtaAdminSqlSessionTemplate(SqlSessionFactory jtaAdminSqlSessionFactory){
        return new SqlSessionTemplate(jtaAdminSqlSessionFactory);
    }
}
