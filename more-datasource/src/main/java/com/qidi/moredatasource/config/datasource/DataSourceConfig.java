package com.qidi.moredatasource.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 多数据源配置类
 * User: qidi
 * Date: 2018/10/10
 * Time: 下午3:46
 */
@Configuration
public class DataSourceConfig {
    /**
     * 第一个数据源配置
     *
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 第一个数据源
     *
     * @return
     */
    @Bean("primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.first" )
    public DataSource primaryDataSource() {
        DataSourceProperties dataSourceProperties= firstDataSourceProperties();
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    /**
     * 第一个数据源配置
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 第二个数据源
     *
     * @return
     */
    @Bean("secondDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource secondDataSource() {
        DataSourceProperties dataSourceProperties= secondDataSourceProperties();
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

}
