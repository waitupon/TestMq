package com.dwh.controller;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloRecevier {
    @Autowired
    private AmqpTemplate template;

//    @RabbitListener(queues="queue")    //监听器监听指定的Queue
//    public void process1() {    //用User作为参数
//       // System.out.println("Receive1:"+user);
//        Message msg = template.receive("topic.delete");
//
//        String str = new String(msg.getBody());
//        System.out.println(str);
//    }
//
    @RabbitListener(queues="topic.all")
    public void process(String str){
        System.out.println("recever all: "+str);
    }


    @RabbitListener(queues="topic.save")
    public void process2(String str){
        System.out.println("recever save: "+str);
    }

    @RabbitListener(queues ="topic.message" )
    public void receiveMessage1(String str){
        System.out.println("我是监听topic.message的,仅满足topic.message的过来 ， "+str);
    }

    @RabbitListener(queues ="topic.notes" )
    public void receiveMessage2(String str) {
        System.out.println("我是监听topic.# 的,满足 topic.# 的都过来 ， " + str);
    }


}
