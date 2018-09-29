package com.qidi.bootdemo.message.provider;

import com.alibaba.fastjson.JSONObject;
import com.qidi.bootdemo.message.beans.Message;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * 引入spring kafka包
 * spring-kafka
 * User: qidi
 * Date: 2018/7/30
 * Time: 上午11:50
 */
@Component
public class KafkaSender {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(KafkaSender.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //发送消息方法
    public void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        String data = JSONObject.toJSONString(message);
        log.info("=========== message ={}", data);
        kafkaTemplate.send("maqidi", data);
    }

}
