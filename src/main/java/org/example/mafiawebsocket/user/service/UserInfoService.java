package org.example.mafiawebsocket.user.service;

import org.example.mafiawebsocket.user.entity.UserInfo;

public interface UserInfoService {

    public UserInfo createUser(String name, String password);
}
