package com.qidi.bootdemo.controller;

import com.qidi.bootdemo.exception.MyException;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 利用springmvc自有的异常捕获机制
 * 没有自适应效果，浏览器和客户端返回的都是 json数据
 * 问题： 不能替换public中﻿404.html -->为404.jsp的主要原因是，默认视图解析器的后缀是html
 * User: qidi
 * Date: 2018/7/23
 * Time: 下午5:12
 */
@ControllerAdvice
public class MyExceptionHandler {

    /*    @ResponseBody
        @ExceptionHandler(MyException.class)
        public Map<String, Object> handleException(Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", 1234);
            map.put("msg",e.getMessage() );
            return map;
        }*/

    /**
     * 抓发到error到自适应的效果
     * 配置了使用thymleaf模版，优先使用error的模版输出
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    public String handleException(Exception e, HttpServletRequest httpServletRequest, Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 404);
        map.put("msg", e.getMessage());
        model.addAttribute("errorMap",map);
        //1. 转发到自己的error页面 使用thymleaf模版
//        return "/error/404";
        //2.定制自适应的错误，通过boot的error自适应解析器
        httpServletRequest.setAttribute("javax.servlet.error.status_code",404);
        return "forward:/error";

    }


}
