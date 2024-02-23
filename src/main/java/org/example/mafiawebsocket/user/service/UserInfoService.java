package org.example.mafiawebsocket.user.service;

import org.example.mafiawebsocket.user.dto.UserInfoJoinRequestDto;
import org.example.mafiawebsocket.user.dto.UserInfoLoginRequestDto;
import org.example.mafiawebsocket.user.entity.User;

public interface UserInfoService {

    public User createUser(UserInfoJoinRequestDto userInfoJoinRequestDto);

    public User getUser(UserInfoLoginRequestDto userInfoLoginRequestDto);
}
