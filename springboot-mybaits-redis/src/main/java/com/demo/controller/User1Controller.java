package com.demo.controller;

import com.demo.model.po.User;
import com.demo.service.UserService;
import com.demo.util.MyPage;
import com.demo.util.PageBean;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user1")
public class User1Controller {
    @Autowired
    UserService userService;


    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") Integer userId){
        User user = userService.getUserById(userId);

        return user;
    }

    @GetMapping("/tran/test")
    public String test1(){
        try {
            return userService.testTranscation();
        }catch (Exception e1){
        }

        return null;
    }

    @GetMapping("/test2")
    public String test2(){
        return "test2";
    }

    @GetMapping("/test3")
    public String test3(){


        return "test3";
    }

    @GetMapping("/page")
    public List<User> getUserPage(Integer pageNum, Integer pageSize){
        if(pageNum == null){
            pageNum = 1;
        }

        if(pageNum < 1){
            pageNum = 1;
        }

        if(pageSize == null){
            pageNum = 5;
        }


        Page<User> page = userService.findByPage(pageNum, pageSize);
        MyPage<User> myPage = new MyPage<>(page);

        System.out.println(myPage.toString());
        return myPage.getList();

    }
}
