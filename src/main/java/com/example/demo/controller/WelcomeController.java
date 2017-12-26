package com.example.demo.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.domain.User;
import com.example.demo.service.UserService;

/**
 * @author phil
 */
@Controller
public class WelcomeController {

	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	@Autowired
	private UserService userService;

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
	public String welcomea(Map<String, Object> model) {
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

	@PostMapping("/update")
	public String update(Map<String, Object> model, User user) {
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

}
