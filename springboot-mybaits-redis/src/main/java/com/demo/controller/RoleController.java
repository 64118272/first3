package com.demo.controller;

import com.demo.model.po.Role;
import com.demo.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleMapper roleMapper;

    @GetMapping("/{id}")
    public Role getUserByRole(@PathVariable("id") Integer id){
        Role role = roleMapper.getUserByRole(id);

        return role;
    }
}
