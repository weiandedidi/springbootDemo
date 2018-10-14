package com.qidi.bootdemo.web.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


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

    @ResponseBody
    @RequestMapping("/hi")
    public Map<String, Object> hi(@RequestParam("message") String message) {
        System.out.println(message);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "success");
        return map;
    }
}
