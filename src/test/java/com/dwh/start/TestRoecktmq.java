package com.dwh.start;

import com.alibaba.fastjson.JSON;
import com.dwh.rocketmq.model.User;
import com.rabbitmq.client.Consumer;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRoecktmq {
    @Autowired
    private DefaultMQProducer defaultProducer;

    @Autowired
    private TransactionMQProducer transactionProducer;


    @Test
    public void sendMsg() {
        for (int i = 0; i < 2; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setUsername("jhp" + i);
            String json = JSON.toJSONString(user);
            Message msg = new Message("user-topic", "white", json.getBytes());
            try {
                SendResult result = defaultProducer.send(msg);
                System.out.println("消息id:" + result.getMsgId() + ":" + "," + "发送状态:" + result.getSendStatus());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
