package com.demo.service;

import com.demo.model.po.User;
import com.github.pagehelper.Page;

public interface UserService {
    public User getUserById(Integer userId);

    public String testTranscation();

    public void hello();

    public Page<User> findByPage(int pageNo, int pageSize);
}
