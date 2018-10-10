package com.dwh.controller;

import com.dwh.config.SenderConf;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate template;

    public void sendTopicSave(String msg) {
        template.convertAndSend(SenderConf.exchangeName,"topic.save",msg);
        System.out.println("send done!");
    }


    public void sendTopicDelete(String msg) {
        template.convertAndSend(SenderConf.exchangeName,"topic.delete",msg);
        System.out.println("send done!");
    }


    public void sendMessage(){
        this.template.convertAndSend("topicExchange","topic.message","我是发送消息的内容! ");
    }
}
