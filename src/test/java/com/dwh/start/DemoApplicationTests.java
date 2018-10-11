package com.dwh.start;

import com.dwh.controller.HelloRecevier;
import com.dwh.controller.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private HelloRecevier recevier;



    @Test
    public void testRecv() {
//          for(;;)
//        recevier.process(new String());

       // recevier.process1();
    }

    @Test
    public void testSend() {
    //    helloSender.sendTopicSave("123");
        for(int i=0;i<100;i++) {
            helloSender.sendTopicDelete("a" + i);
        }
      //  helloSender.sendMessage();
    }
}
