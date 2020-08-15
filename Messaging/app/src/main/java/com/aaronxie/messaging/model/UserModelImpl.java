package com.aaronxie.messaging.model;

import com.aaronxie.messaging.bean.User;

import java.util.ArrayList;
import java.util.Random;

/**
 * create by Aaron Xie
 * on 2020/8/12
 * description:
 */
public class UserModelImpl {
    private static final String TAG = UserModelImpl.class.getSimpleName();

    public UserModelImpl() {

    }

    public void onLoadUserData(IUserModel iUserModel) {
        ArrayList<User> users = new ArrayList<>();
        int len = 5 + new Random().nextInt(20);
        for (int i = 0; i < len; i++) {
            User user = new User();
            user.setAge(25);
            user.setName("aaron");
            users.add(user);
        }
        if (iUserModel != null) {
            iUserModel.getUserData(users);
        }
    }
}
