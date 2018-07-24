package com.qidi.bootdemo.web.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/24
 * Time: 下午4:54
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("我是 MyApplicationRunner。。。。");
    }
}
