package com.qidi.moredatasource.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 如果两个包扫描的是一个dao，那么只会用primary的数据库
 * User: qidi
 * Date: 2018/10/10
 * Time: 下午4:59
 */
@Configuration
@MapperScan(value = "com.qidi.moredatasource.dao.zoo2.userV2", sqlSessionFactoryRef = "secondSqlSessionFactory")
public class SecondSqlSessionFactoryConifg {

    @Autowired
    private Environment environment;  // (1)

    /**
     * 第二sql的模版
     *
     * @param secondDataSource
     * @return
     */
    @Bean("secondSqlSessionFactory")
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("secondDataSource") DataSource secondDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(secondDataSource);
        //配置mapperlocations
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(environment.getProperty("mybatis.mapper-locations")));
        return bean.getObject();
    }
}
