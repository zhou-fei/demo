package com.example.demo.mq;

import com.example.demo.mq.activemq.ActiveMQConsumer;
import com.example.demo.mq.activemq.ActiveMQProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

/**
 *
 * User: Phil. Date: 2018/2/2 Time: 14:47 Created by IntelliJ IDEA.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MqTest {
	@Autowired
	private ActiveMQProducer producer;

    @Autowired
    private ActiveMQConsumer consumer;

	@Test
	public void contextLoads() throws InterruptedException {
		Destination destination = new ActiveMQQueue("mytest.queue");

		for (int i = 0; i < 100; i++) {
			producer.sendMessage(destination, "myname is "+ i);
		}
	}

}
