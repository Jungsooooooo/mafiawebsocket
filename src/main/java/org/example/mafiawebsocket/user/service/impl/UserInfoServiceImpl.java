package org.example.mafiawebsocket.user.service.impl;

import org.example.mafiawebsocket.user.dto.UserInfoJoinRequestDto;
import org.example.mafiawebsocket.user.entity.UserInfo;
import org.example.mafiawebsocket.user.service.UserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Override
    public UserInfo createUser(UserInfoJoinRequestDto userInfoJoinRequestDto) {

        return UserInfo.builder().name(userInfoJoinRequestDto.getName())
                                 .password(userInfoJoinRequestDto.getPassword())
                                 .role(userInfoJoinRequestDto.getRole())
                                 .build();
    }
}
