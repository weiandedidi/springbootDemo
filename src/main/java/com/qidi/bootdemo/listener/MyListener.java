package com.qidi.bootdemo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * servlet的监听器
 * User: qidi
 * Date: 2018/7/23
 * Time: 下午7:03
 */
@WebListener
public class MyListener implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(MyListener.class);
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("初始化的时候监听一下。。。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("销毁的时候监听一下。。。");

    }
}
