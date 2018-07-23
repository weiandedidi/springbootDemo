package com.qidi.bootdemo.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyHttpSessionListener
 * 通过  @WebListener 或者 使用代码注册  ServletListenerRegistrationBean
 * User: qidi
 * Date: 2018/7/23
 * Time: 下午7:15
 */
public class MyHttpListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("HttpSessionListener 监听器");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("HttpSessionListener 拦截器");

    }
}
