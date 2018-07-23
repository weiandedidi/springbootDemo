package com.qidi.bootdemo.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 自定义过滤器
 * User: qidi
 * Date: 2018/7/23
 * Time: 下午6:50
 */
@Component
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class MyFilter implements Filter {
    /**
     * 执行过滤操作
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("启动的时候过滤器初始化。。。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("执行过滤操作。。。");
    }

    @Override
    public void destroy() {
        System.out.println("shutdown的时候滤器销毁。。。");
    }
}
