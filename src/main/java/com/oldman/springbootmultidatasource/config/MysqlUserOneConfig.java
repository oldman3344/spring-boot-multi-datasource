package com.oldman.springbootmultidatasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.oldman.springbootmultidatasource.mapper.datasourceOne",sqlSessionFactoryRef = "oneSqlSessionFactory")
public class MysqlUserOneConfig {

    @Primary
    @Bean("dataSourceOne")
    @ConfigurationProperties(prefix = "spring.datasource.mysqluserone")
    public DataSource getOneDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public SqlSessionFactory oneSqlSessionFactory(@Qualifier("dataSourceOne") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        //sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource("classpath*:mapper/one/*.xml"));
        return sessionFactoryBean.getObject();
    }

    @Primary
    @Bean
    public DataSourceTransactionManager oneTransactionManager(@Qualifier("dataSourceOne") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean
    public SqlSessionTemplate oneSqlSessionTemplate(@Qualifier("oneSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
