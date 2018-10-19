package com.example.demo.mq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 *
 * User: Phil.
 * Date: 2018/10/19
 * Time: 11:12
 * Created by IntelliJ IDEA.
 */
@Service
public class Consumer {
    @RabbitHandler
    @RabbitListener(queues = "myTest.rabbitMQ")
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }
}
