package com.qidi.bootdemo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/25
 * Time: 下午8:20
 */
@Service
public class MyTask {

    @Scheduled(cron = "* * * * * *")
    public void sayHello() {
        System.out.println("我是 一个定时任务");
    }
}
