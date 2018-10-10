package com.qidi.moredatasource.config.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 事务配置
 * User: qidi
 * Date: 2018/10/10
 * Time: 下午5:01
 */
@SpringBootConfiguration
public class TransactionManagerConfig {

    @Bean("primaryTransactionManager")
    @Primary
    public PlatformTransactionManager primaryTransactionManager(@Qualifier("primaryDataSource") DataSource primaryDataSource) {
        return new DataSourceTransactionManager(primaryDataSource);
    }

    @Bean("secondTransactionManager")
    public PlatformTransactionManager secondTransactionManager(@Qualifier("secondDataSource") DataSource secondDataSource) {
        return new DataSourceTransactionManager(secondDataSource);
    }


}
