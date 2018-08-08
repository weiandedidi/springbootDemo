package com.qidi.bootdemo.config;

import com.qidi.bootdemo.interceptor.ControllerInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * springboot 2.x后废弃WebMvcConfigurerAdapter 该用WebMvcConfigurer
 * 新写法：
 *  先写个 拦截器extends HandlerInterceptorAdapter
 * 实现方法：
 * 1。implements WebMvcConfigurer ${@link WebMvcConfigurer}, 实现拦截器注册方法。
 * 2。 extends WebMvcConfigurationSupport ${@link WebMvcConfigurationSupport} 重写addInterceptors
 *
 * User: qidi
 * Date: 2018/8/8
 * Time: 上午10:09
 */
@Component
public class MVCInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ControllerInterceptor()).addPathPatterns("/**");
    }
}
