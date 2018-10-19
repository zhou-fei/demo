package com.example.demo.mq.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 *
 * User: Phil.
 * Date: 2018/2/2
 * Time: 14:45
 * Created by IntelliJ IDEA.
 */
@Service
public class ActiveMQConsumer {
    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "myTest.activeMQ")
     public void receiveQueue(String text) {
    System.out.println("Consumer收到的报文为:"+text);
    }
}
