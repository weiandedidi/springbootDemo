package com.qidi.bootdemo.web.controller;

import org.eclipse.jetty.client.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/18
 * Time: 上午11:26
 */
@RestController
//@Slf4j
public class HelloWorldController {
    private Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping("/hello")
    public String index() {
        logger.trace("这是trace");
        logger.debug("i am a debug log");
        logger.info("这是info");
        logger.warn("这是警告");
        logger.error("这是error");
        return "Hello World";
    }
}
