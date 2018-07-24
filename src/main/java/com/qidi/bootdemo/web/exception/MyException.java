package com.qidi.bootdemo.web.exception;

/**
 * 自定义异常
 * User: qidi
 * Date: 2018/7/23
 * Time: 下午5:03
 */
public class MyException extends RuntimeException{

    public MyException() {
        super("用户不存在");
    }
}
