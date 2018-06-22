package com.demo.service;

public interface RedisService {
    public void set(String k, String v);
    public String get(String k);
}
