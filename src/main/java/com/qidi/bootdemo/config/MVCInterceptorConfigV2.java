package com.qidi.bootdemo.config;

import com.qidi.bootdemo.interceptor.ControllerInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/8
 * Time: 上午11:02
 */
//@Component
public class MVCInterceptorConfigV2 extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ControllerInterceptor()).addPathPatterns("/**");
    }
}
