package com.qidi.bootdemo.message.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息实体类
 * User: qidi
 * Date: 2018/7/30
 * Time: 上午11:48
 */
public class Message implements Serializable {

    private Long id;    //id

    private String msg; //消息

    private Date sendTime;  //时间戳

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
