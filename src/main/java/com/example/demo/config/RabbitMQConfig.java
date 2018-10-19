package com.example.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * User: Phil.
 * Date: 2018/10/19
 * Time: 11:06
 * Created by IntelliJ IDEA.
 */
@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue Queue() {
        return new Queue("myTest.rabbitMQ");
    }
}
