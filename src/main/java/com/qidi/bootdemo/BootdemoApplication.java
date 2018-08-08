package com.qidi.bootdemo;

import com.qidi.bootdemo.message.provider.KafkaSender;
import com.qidi.bootdemo.utils.SpringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Locale;


/**
 * springboot使用@EnableTransactionManagement 开启事务 并使用@Transactional 注释在相应方法上
 */

//servlet组件扫描
@ServletComponentScan    //servlet组件扫描
@SpringBootApplication
@EnableScheduling    //开启定时任务
@EnableAsync    //开启异步调用
@EnableTransactionManagement    //开启事务
@EnableSwagger2 //开启swagger注解
public class BootdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootdemoApplication.class, args);

/*
        启动kafka 发送线程
        KafkaSender sender = SpringUtils.getBean(KafkaSender.class);
        for (int i = 0; i < 3; i++) {
            //调用消息发送类中的消息发送方法
            sender.send();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
*/
    }

    @Bean
    public ViewResolver myViewResoler() {
        return new MyViewResoler();
    }

    private static class MyViewResoler implements ViewResolver {

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}
