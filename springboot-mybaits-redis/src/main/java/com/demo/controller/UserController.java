package com.demo.controller;

import com.demo.model.po.User;
import com.demo.mapper.UserMapper;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") Integer userId){
        User user = userMapper.getUserById(userId);

        return user;
    }

    @GetMapping("/cache/{userId}")
    public User testCache(@PathVariable("userId") Integer userId){
        User user = userMapper.getUserById(userId);

        return user;
    }

    @GetMapping("/bids/{id}")
    public User getUserAndBidsById(@PathVariable("id") Integer id) {
        User user = userMapper.getUserAndBidsById(id);

        return user;
    }

    @GetMapping("/bids/bills/{id}")
    public User getUserAndBidsAndBillsById(@PathVariable("id") Integer id){
        User user = userMapper.getUserAndBidsAndBillsById(id);

        System.out.println("-------------" + user.getBidList().size());
        return user;
    }

    @GetMapping("/roles/{id}")
    public User selectRoleByUser(@PathVariable("id") Integer id){
        User user = userMapper.selectRoleByUser(id);

        return user;
    }

    @GetMapping("/userAll")
    public User getUserAll(Integer id){
        User user = userMapper.getUserAll(id);

        return user;
    }

    @GetMapping("/lazy/{userId}")
    public User getUserByIdLazy(@PathVariable("userId") Integer userId){
        User user = userMapper.getUserByIdLazy(userId);

        System.out.println("-----------------------------------------------\n");
       System.out.println(user.getBidList().size());

        return user;
    }


    @GetMapping("/update")
    public User updateUserById(User user){
        userMapper.updateUserById(user);

        return user;
    }

    @GetMapping("/insert")
    public User insert(User user){
        userMapper.insertUser(user);

        return user;
    }



}
