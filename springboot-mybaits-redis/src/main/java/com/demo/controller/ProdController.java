package com.demo.controller;

import com.demo.mapper.ProdMapper;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/28.
 */
@RestController
@RequestMapping("/produce")
public class ProdController {
    @Autowired
    ProdMapper prodMapper;

    @GetMapping("/test1")
    public int test1(String param1, Double param2){
        Map<String, Object> map = new HashMap<>();
        map.put("param1", param1);
        map.put("param2", param2);

        prodMapper.testProd1(map);

        return 1;
    }

    @GetMapping("/test2")
    public String testInParamWithDatetime(String param1, Double param2){
        Map<String, Object> map = new HashMap<>();
        map.put("param1", param1);
        map.put("param2", param2);
//        map.put("param3", "2018-05-29");
//      日期不能带毫秒，不然会无法识别
        map.put("param3", "2008-1-2 03:04:44");

        prodMapper.testProd2(map);

        return "finish";
    }

    @GetMapping("/test3")
    public Map testInParamWithOut(String param1, Double param2){
        Map<String, Object> map = new HashMap<>();
        map.put("param1", param1);
        map.put("param2", param2);

//      参数返回在map中实现，不主张通过存储过程获取一段数据，因为无法用缓存
        prodMapper.testProd3(map);

        return map;
    }
}
