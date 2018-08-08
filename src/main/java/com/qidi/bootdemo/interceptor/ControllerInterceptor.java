package com.qidi.bootdemo.interceptor;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.HttpCookie;

/**
 * springMVC拦截器
 * User: qidi
 * Date: 2018/7/24
 * Time: 下午4:46
 */
@Component
public class ControllerInterceptor extends HandlerInterceptorAdapter {

//    预处理
    //可以进行编码、安全控制等处理；
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie cookie = new Cookie("abc", "meme");
        response.addCookie(cookie);
        Cookie cookieV2 = new Cookie("yyy", "zzz");
        response.addCookie(cookieV2);

        return super.preHandle(request, response, handler);
    }

    //有机会修改ModelAndView
//    调用了Service并返回ModelAndView，但未进行页面渲染
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Cookie cookie = new Cookie("bcd", "xxx");
        response.addCookie(cookie);
        super.postHandle(request, response, handler, modelAndView);
    }

    //已经渲染了页面 返回处理了 可以根据ex是否为null判断是否发生了异常，进行日志记录。
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Cookie cookie = new Cookie("yyy", "zzz");
        response.addCookie(cookie);
        super.afterCompletion(request, response, handler, ex);
//        完成后做些东西异步的
    }
}
