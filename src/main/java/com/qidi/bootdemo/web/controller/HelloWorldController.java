package com.qidi.bootdemo.web.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 热部署 cmd+F9 实现热部署。
 * User: qidi
 * Date: 2018/7/18
 * Time: 上午11:26
 */

@RestController
//@Slf4j
public class HelloWorldController {
    private Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @ApiOperation(value = "首页", notes = "获取首页")
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
