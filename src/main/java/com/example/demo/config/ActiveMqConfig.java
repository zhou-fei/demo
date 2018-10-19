package com.example.demo.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 *
 * User: Phil.
 * Date: 2018/10/19
 * Time: 11:01
 * Created by IntelliJ IDEA.
 */
@Configuration
public class ActiveMqConfig {
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("myTest.activeMQ");
    }
}
