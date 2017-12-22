package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 *
 * User: Phil.
 * Date: 2017/12/22
 * Time: 14:31
 * Created by IntelliJ IDEA.
 */
@Configuration
public class JedisPoolConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.pool.max-wait}")
    private long maxWaitMillis;

    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public redis.clients.jedis.JedisPoolConfig getRedisConfig(){
        return new redis.clients.jedis.JedisPoolConfig();
    }

    @Bean
    public JedisPool getJedisPool(){
        redis.clients.jedis.JedisPoolConfig config = getRedisConfig();
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(maxWaitMillis);
        return new JedisPool(config,host,port,timeout);
    }

}
