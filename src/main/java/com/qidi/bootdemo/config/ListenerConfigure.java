package com.qidi.bootdemo.config;

import com.qidi.bootdemo.listener.MyHttpListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/23
 * Time: 下午7:18
 */
public class ListenerConfigure {

    public ServletListenerRegistrationBean<MyHttpListener> serssionListenerBean(){
        ServletListenerRegistrationBean<MyHttpListener> sessionListener = new ServletListenerRegistrationBean<MyHttpListener>(new MyHttpListener());
        return sessionListener;

    }
}
