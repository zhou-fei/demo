package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedisPool;

/**
 *
 * User: Phil.
 * Date: 2017/12/22
 * Time: 14:34
 * Created by IntelliJ IDEA.
 */
@Component
public class JedisUtil {

    @Autowired
    private ShardedJedisPool jedisPool;

    @Autowired
    private RedisTemplate redisTemplate;

    public String get() {
        return jedisPool.getResource().get("a");
    }

    public String get2() {
        return redisTemplate.opsForValue().get("a").toString();
    }

    //



}
