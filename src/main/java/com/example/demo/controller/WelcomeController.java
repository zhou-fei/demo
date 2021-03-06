package com.example.demo.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.jms.Destination;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.model.enumeration.ResponseEnum;
import com.example.demo.model.vo.Response;
import com.example.demo.mq.activemq.ActiveMQProducer;
import com.example.demo.mq.rabbitmq.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.domain.User;
import com.example.demo.service.UserService;

/**
 * @author phil
 */
@Controller
@Slf4j
public class WelcomeController {

	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private ActiveMQProducer producer;

	@Autowired
	private Producer rProducer;

	@PostConstruct
	public void logSomething() {
		logger.debug("Sample Debug Message");
		logger.trace("Sample Trace Message");
	}

	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		logger.debug("Sample Debug Message");
		logger.error("Sample Debug Message");
		logger.trace("Sample Trace Message");
		model.put("time", new Date());
		String message = "Hello World";
		model.put("message", message);
		return "welcome";
	}

	@GetMapping("/a")
	public String welcomea(Map<String, Object> model, HttpServletResponse httpServletResponse) {
		Cookie cookie = new Cookie("aaa", "bbbbb");
		cookie.setDomain("ssssssss");
		cookie.setPath("/sssssssssss");
		Cookie cookie1 = new Cookie("ccc", "bbbxxxxxbb");
		httpServletResponse.addCookie(cookie);
		httpServletResponse.addCookie(cookie1);
		logger.debug("Sample Debug Message debug");
		logger.info("Sample Debug Message info");
		logger.error("Sample Debug Message error");
		logger.trace("Sample Trace Message trace");
		model.put("time", new Date());
		String message = "Hello World";
		model.put("message", message);
		model.put("user", userService.getUser());
		return "welcomea";
	}

	@RequestMapping("/update")
	public String update(Map<String, Object> model, User user , HttpServletRequest request) {
		Cookie[] a = request.getCookies();
		System.out.println(a);
		logger.info("uuuuuuuuuuuuuu", user);
		model.put("time", new Date());
		String message = "Hello World";
		model.put("message", message);
		userService.update(user);
		model.put("user", userService.getUser());
		return "welcomea";
	}

	@GetMapping("/c")
	@ResponseBody
	public User welcomea1(Map<String, Object> model) {
		User user = userService.getUser();
		return user;
	}

	@GetMapping("/enum")
	@ResponseBody
	public Response<String> welcomea2(Map<String, Object> model) {
		Response<String> response = new Response<String>(ResponseEnum.SUCCESS, "haaaaaaaaaaaa");
		return response;
	}

	@GetMapping("/hello")
	public String hello(Map<String, Object> model, User user) {
		return "helloworld";
	}

	@GetMapping("/mq")
	@ResponseBody
	public void testMq(){
		Destination destination = new ActiveMQQueue("myTest.activeMQ");

		for (int i = 0; i < 100; i++) {
			producer.sendMessage(destination, "Producer发出报文"+ i);
		}
	}

	@GetMapping("/rq")
	@ResponseBody
	public void testRabbitMq(){
		rProducer.send();
	}
}
