package com.qidi.moredatasource.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 建议使用HikariConfig的配置进行一次配置，而不是datasource
 * User: qidi
 * Date: 2018/10/10
 * Time: 下午4:48
 */
@Configuration
@MapperScan(value = "com.qidi.moredatasource.dao.zoo.user", sqlSessionFactoryRef = "primarySqlSessionFactory")
public class PrimarySqlSessionFactoryConfig {


    @Autowired
    private Environment environment;  // (1)

    /**
     * 第一sql的模版
     *
     * @param primaryDataSource
     * @return
     */
    @Bean("primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDataSource") DataSource primaryDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(primaryDataSource);
        //配置mapperlocations
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(environment.getProperty("mybatis.mapper-locations")));
        return bean.getObject();
    }
}
