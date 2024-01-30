package org.example.mafiawebsocket.user.service.impl;

import org.example.mafiawebsocket.user.entity.UserInfo;
import org.example.mafiawebsocket.user.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {

    @Override
    public UserInfo createUser(String name, String password) {

        return UserInfo.builder().name(name).password(password).build();
    }
}
