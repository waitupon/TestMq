package com.dwh.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SenderConf {
//    public static String exchangeName = "topic.exchange";
//    public static String saveRoute = "topic.save";
//    public static String allTopicRoute = "topic.all";
//    public static String allRoute = "topic.#";
//
//    @Bean(name="message")
//    public Queue queue() {
//        return new Queue(saveRoute);
//    }
//
//    @Bean(name = "notes")
//    public Queue queueMessages(){
//        return new Queue(allTopicRoute);
//    }
//
//    @Bean
//    public TopicExchange exchange(){
//        return new TopicExchange(exchangeName);
//    }
//
//
//    @Bean
//    Binding bindingExchangeMessage(@Qualifier("message") Queue queueMessage, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessage).to(exchange).with(saveRoute);
//    }
//
//    @Bean
//    Binding bindingExchangeMessages(@Qualifier("notes") Queue queueMessages, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessages).to(exchange).with(allRoute);
//    }

}

