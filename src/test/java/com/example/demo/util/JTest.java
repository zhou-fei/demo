package com.example.demo.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 *
 * User: Phil.
 * Date: 2017/12/22
 * Time: 14:21
 * Created by IntelliJ IDEA.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JTest {

    @Autowired
    private JedisUtil jedisUtil;

    @Test
    public void test2() {
        String a = jedisUtil.get();
        //assert ("2222222222".equals(a));

        System.out.println(jedisUtil.get2());

    }
}
