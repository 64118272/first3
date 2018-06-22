package com.demo.service.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/29.
 */

/*
 * second, minute, hour, day of month, month, and day of week.
 * 0 * * * * 0-7
 * 0与7都表示星期天0-7表示一周所有的时间段，以上表示一分钟执行一次
 */
@Service
public class Job1 {
//  每分钟执行一次,且为整点
    @Scheduled(cron = "0 * * * * 0-7")
    public void oneMinitus(){
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String s = sdf.format(dt);
        System.out.println(s +" : 第一分钟执行一次");
    }

//逗号表示枚举
//    @Scheduled(cron = "0,5,10,20,25 * * * * 0-7")
//    public void oneHour(){
//        Date dt = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
//        String s = sdf.format(dt);
//        System.out.println(s +" : 第分钟的0，5，10，20，25秒执行一次");
//    }

// - 表示范围 从xx到xx
//    @Scheduled(cron = "0-10 * * * * 0-7")
//    public void j1(){
//        Date dt = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
//        String s = sdf.format(dt);
//        System.out.println(s +" : 0到10秒，每秒都执行一次");
//    }

//    @Scheduled(cron = "5/10 * * * * 0-7")
    public void j1(){
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String s = sdf.format(dt);
        System.out.println(s +" : 第5秒开始，每隔10秒都执行一次");
    }
}

