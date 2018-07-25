package com.qidi.bootdemo.service.ansy;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/25
 * Time: 下午8:31
 */
@Service
@Aysnc
public class AnsyService {

    public void sayHello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中。。。");
    }

}
