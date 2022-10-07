package com.example.redisTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class redisDemoTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void set1(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("key1653", "valus1111");
        System.out.println(ops.get("key1653"));
    }

    @Test
    void set(){
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("age", 41);
        System.out.println("age: " + ops.get("age"));
    }

    @Test
    void setHaset(){
        HashOperations ops = redisTemplate.opsForHash();
        ops.put("user", "age", 41);
        System.out.println(ops.get("user", "age"));
    }




}
