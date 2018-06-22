package com.demo.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User extends  Base implements Serializable {
    private String name;
    private String realityName;
    private Integer userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss SSS")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss SSS")
    private Date  userCreateTime;

    private List<Bid> bidList;

    private List<Role> roleList;
    private UserExt1 userExt1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealityName() {
        return realityName;
    }

    public void setRealityName(String realityName) {
        this.realityName = realityName;
    }

    public List<Bid> getBidList() {
        return bidList;
    }

    public void setBidList(List<Bid> bidList) {
        this.bidList = bidList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public UserExt1 getUserExt1() {
        return userExt1;
    }

    public void setUserExt1(UserExt1 userExt1) {
        this.userExt1 = userExt1;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }
}

