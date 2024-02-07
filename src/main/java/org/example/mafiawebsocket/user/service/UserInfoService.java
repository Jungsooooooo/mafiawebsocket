package org.example.mafiawebsocket.user.service;

import org.example.mafiawebsocket.user.dto.UserInfoJoinRequestDto;
import org.example.mafiawebsocket.user.dto.UserInfoLoginRequestDto;
import org.example.mafiawebsocket.user.entity.UserInfo;

public interface UserInfoService {

    public UserInfo createUser(UserInfoJoinRequestDto userInfoJoinRequestDto);

    public UserInfo getUser(UserInfoLoginRequestDto userInfoLoginRequestDto);
}
