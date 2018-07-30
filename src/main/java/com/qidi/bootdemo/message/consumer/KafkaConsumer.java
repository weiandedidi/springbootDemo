package com.qidi.bootdemo.message.consumer;

import com.alibaba.fastjson.JSONObject;
import com.qidi.bootdemo.message.beans.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/30
 * Time: 下午1:00
 */
@Component
@Slf4j
public class KafkaConsumer {

    //接收就是一直接收
    @KafkaListener(topics = {"maqidi"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {

            String message = (String) kafkaMessage.get();
            Message msg = JSONObject.parseObject(message,Message.class);


            log.info("----------------- record =" + record);
            log.info("------------------ id is" + msg.getId());
            log.info("------------------ msg is" + msg.getMsg());
            log.info("------------------ time is" + msg.getSendTime());
        }

    }
}
