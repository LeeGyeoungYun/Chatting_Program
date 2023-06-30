package com.exam.chatting.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.RequiredArgsConstructor;

@Configuration
@PropertySource("classpath:/application.properties")
@RequiredArgsConstructor
public class DatabaseConfig {
	
	private final ApplicationContext context;
	
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }
    
    //sqlSessionFactory와 sqlSessionTemplate는 Mybatis를 사용하기위해 빈에 등록해야만 합니다.
    //sqlSessionFactory는 DB의 커넥션과, SQL 실행에 대한 모든 것을 갖는 객체입니다.
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        // factoryBean.setMapperLocations(context.getResources("classpath:/mappers/**/*Mapper.xml"));
        return factoryBean.getObject();
    }
    
    //SQL sqlSession은 실행에 필요한 모든 메서드(INSERT, UPDATE, DELETE, SELECT)를 갖는 객체입니다.
    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

}