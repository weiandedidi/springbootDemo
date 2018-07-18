package com.qidi.bootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/18
 * Time: 下午3:52
 */
@Controller
public class JspController {
    @RequestMapping("/hellojsp/")
    public String helloJsp(){
        return "";
    }
}
