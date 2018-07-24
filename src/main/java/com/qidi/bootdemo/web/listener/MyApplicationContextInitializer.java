package com.qidi.bootdemo.web.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/24
 * Time: 下午4:48
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("ConfigurableApplicationContext init "+ configurableApplicationContext);
    }
}
