package com.dwh.rabbitmq.controller;

import com.dwh.rabbitmq.config.AmqpConfig;
import com.dwh.rabbitmq.model.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HelloSender implements RabbitTemplate.ReturnCallback{
    @Autowired
    private RabbitTemplate template;


    public void sendTopicDelete(User msg) {
        template.setReturnCallback(this);

        template.setConfirmCallback((correlationData, ack, cause)->{
            if (!ack) {
                    System.out.println("HelloSender消息发送失败" + cause);
            } else {
                System.out.println("HelloSender 消息发送成功 ");
            }

        });

        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        template.convertAndSend(AmqpConfig.EXCHANGE_NAME,"topic.baqgl.save",msg,correlationData);
        System.out.println("send done!");
    }


    public void sendMessage(){
        this.template.convertAndSend("topicExchange","topic.message","我是发送消息的内容! ");
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("sender return success" + message.toString()+"==="+replyCode+"==="+replyText+"==="+exchange+"===="+routingKey);

    }
}
