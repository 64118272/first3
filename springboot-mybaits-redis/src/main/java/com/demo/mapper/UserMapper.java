package com.demo.mapper;

import com.demo.model.po.User;
import com.github.pagehelper.Page;

//@Mapper
public interface UserMapper {

    public User getUserById(Integer id);

    public User getUserAndBidsById(Integer id);

    public User getUserAndBidsAndBillsById(Integer id);

    public User selectRoleByUser(Integer id);

    public User getUserAll(Integer id);

    public User getUserByIdLazy(Integer userId);

    public int updateUserById(User user);

    public int insertUser(User user);

    public Page<User> findByPage();
}
