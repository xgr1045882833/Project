package com.aaronxie.messaging.model;

import com.aaronxie.messaging.bean.User;

import java.util.List;

/**
 * create by Aaron Xie
 * on 2020/8/15
 * description:
 */
public interface IUserModel {
    void getUserData(List<User> users);
}
