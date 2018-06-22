package com.demo.compont;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedisCache implements Cache {

    private  static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

    private RedisTemplate redisTemplate;

    private  final String id;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static final long EXPIRE_TIME_IN_MINUTES = 30; // redis过期时间

    public RedisCache(String id){
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        try {
                RedisTemplate redisTemplate = getRedisTemplate();
            if(redisTemplate == null){
                System.out.println("----------redisTemplate is null.");
            }
//            黑认过期时间为30分钟
            redisTemplate.opsForValue().set(key, value, EXPIRE_TIME_IN_MINUTES, TimeUnit.MINUTES);


            logger.debug("Put query result to redis");
        }
        catch (Throwable t) {
            logger.error("Redis put failed", t);
        }
    }

    @Override
    public Object getObject(Object key) {
        try {
            return this.redisTemplate.opsForValue().get(key);
        }catch (Throwable t){
            logger.error("redis get object failre./r/n" + t);
        }

        return null;
    }

    @Override
    public Object removeObject(Object key) {
        try {
            this.redisTemplate.delete(key);
        }catch (Throwable t){
            logger.error("redis remove object faileure /r/n" + t);
        }

        return null;
    }

    @Override
    public void clear() {
        try {
            redisTemplate.execute((RedisCallback) connection -> {
                connection.flushDb();
                return null;
            });
        }catch (Throwable t){
            logger.error("clear redis failure /r/n" + t);
        }
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    private RedisTemplate getRedisTemplate(){
        if (redisTemplate == null) {
            redisTemplate = ApplicationContextHolder.getBean("redisTemplate");
        }

        return this.redisTemplate;
    }
}
