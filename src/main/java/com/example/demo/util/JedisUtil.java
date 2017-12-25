package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisPool;

/**
 * @author phil
 */
@Component
public class JedisUtil {

	@Autowired
	private JedisPool jedisPool;

	@Autowired
	private RedisTemplate redisTemplate;

	public String get() {
		return jedisPool.getResource().get("a");
	}

	public String get2() {
		return redisTemplate.opsForValue().get("a").toString();
	}
}
