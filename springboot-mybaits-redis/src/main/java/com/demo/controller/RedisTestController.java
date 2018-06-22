package com.demo.controller;

import com.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisTestController {
    @Autowired
    RedisService redisService;

    @GetMapping("/set")
    public String setStringValue(String k, String v){
        redisService.set(k, v);

        return k + "," + v;
    }

    @GetMapping("/get")
    public String getValue(String k ){
        return redisService.get(k);
    }

}
