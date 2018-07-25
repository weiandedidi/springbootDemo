package com.qidi.bootdemo.web.controller;

import com.qidi.bootdemo.service.ansy.AnsyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/25
 * Time: 下午8:34
 */
@RestController
public class AnsyController {

    @Autowired
    AnsyService ansyService;

    @RequestMapping("/ansy")
    public String hello(){
        ansyService.sayHello();
        return "success";
    }
}
