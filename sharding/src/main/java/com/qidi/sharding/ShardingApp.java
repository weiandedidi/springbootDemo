package com.qidi.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/24
 * Time: 上午11:03
 */
@SpringBootApplication
@MapperScan("com.qidi.sharding.dao")
@EnableTransactionManagement
public class ShardingApp {
    public static void main(String[] args) {
        SpringApplication.run(ShardingApp.class, args);
    }

}
