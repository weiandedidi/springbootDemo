package com.qidi.bootdemo.config;

import com.qidi.bootdemo.component.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/23
 * Time: 下午4:12
 */
@SpringBootConfiguration
public class MyMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginHandlerInterceptor loginHandlerInterceptor;

    /**
     * 自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //todo 使用拦截器
//        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/index.html","/","/login","/dologin");
         //排除放行请求
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/templates");
    }
}
