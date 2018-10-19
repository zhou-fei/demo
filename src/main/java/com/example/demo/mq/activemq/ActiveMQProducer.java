package com.example.demo.mq.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Destination;

/**
 *
 * User: Phil. Date: 2018/2/2 Time: 14:40 Created by IntelliJ IDEA.
 */
@Service
public class ActiveMQProducer {
	/**
	 * 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
	 */
	@Autowired
	private JmsMessagingTemplate jmsTemplate;

	/**
	 * 发送消息，destination是发送到的队列，message是待发送的消息
	 * @param destination
	 * @param message
	 */
	@Transactional
	public void sendMessage(Destination destination, final String message) {
		jmsTemplate.convertAndSend(destination, message);
	}
}
