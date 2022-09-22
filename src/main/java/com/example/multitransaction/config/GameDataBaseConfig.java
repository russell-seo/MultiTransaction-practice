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
@MapperScan(basePackages = {"com.example.multitransaction.mapper.game"}, sqlSessionFactoryRef = "gameSqlSessionFactory")
public class GameDataBaseConfig {

    @Bean(name = "gameSqlSessionFactory")
    public SqlSessionFactory gameSqlSessionFactory(@Qualifier("gameDataSource") DataSource gameDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(gameDataSource);

        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:com/example/multitransaction/mapper/game/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "gameSqlSessionTemplate")
    public SqlSessionTemplate gameSqlSessionTemplate(SqlSessionFactory gameSqlSessionFactory){
        return new SqlSessionTemplate(gameSqlSessionFactory);
    }



}
