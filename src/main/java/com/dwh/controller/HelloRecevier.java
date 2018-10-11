package com.dwh.controller;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
@RabbitListener(queues="topic.all")
public class HelloRecevier {
//    @Autowired
//    private AmqpTemplate template;

    @RabbitHandler
    public void process(String hello, Channel channel, Message message) throws IOException {
        System.out.println("HelloReceiver收到  : " + hello +"收到时间"+new Date());
          try {
         //   告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
//                channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//                Thread.sleep(1000);
                System.out.println("receiver success");
              } catch (Exception e) {
                  e.printStackTrace();
               //  丢弃这条消息
                 channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
                         System.out.println("receiver fail");
                }
      }




//    @RabbitListener(queues="queue")    //监听器监听指定的Queue
//    public void process1() {    //用User作为参数
//       // System.out.println("Receive1:"+user);
//        Message msg = template.receive("topic.delete");
//
//        String str = new String(msg.getBody());
//        System.out.println(str);
//    }
//
//    @RabbitListener(queues="topic.all")
//    public void process(String str){
//        System.out.println("recever all: "+str);
//    }
//
//
//    @RabbitListener(queues="topic.save")
//    public void process2(String str){
//        System.out.println("recever save: "+str);
//    }
//
//    @RabbitListener(queues ="topic.message" )
//    public void receiveMessage1(String str){
//        System.out.println("我是监听topic.message的,仅满足topic.message的过来 ， "+str);
//    }
//
//    @RabbitListener(queues ="topic.notes" )
//    public void receiveMessage2(String str) {
//        System.out.println("我是监听topic.# 的,满足 topic.# 的都过来 ， " + str);
//    }


}
