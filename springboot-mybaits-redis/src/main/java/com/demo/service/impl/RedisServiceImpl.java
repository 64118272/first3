package com.demo.service.impl;

import com.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String k, String v) {
        stringRedisTemplate.opsForValue().set(k, v);
    }

    @Override
    public String get(String k) {
        return stringRedisTemplate.opsForValue().get(k);
    }
}
