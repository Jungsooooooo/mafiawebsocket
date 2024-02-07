package org.example.mafiawebsocket.user.service.impl;

import org.example.mafiawebsocket.user.dto.UserInfoJoinRequestDto;
import org.example.mafiawebsocket.user.dto.UserInfoLoginRequestDto;
import org.example.mafiawebsocket.user.entity.UserInfo;
import org.example.mafiawebsocket.user.repository.UserInfoRepository;
import org.example.mafiawebsocket.user.service.UserInfoService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository){
        this.userInfoRepository = userInfoRepository;

    }

    @Override
    public UserInfo createUser(UserInfoJoinRequestDto userInfoJoinRequestDto) {

        UserInfo userInfo = UserInfo.builder().name(userInfoJoinRequestDto.getName())
                .password(userInfoJoinRequestDto.getPassword())
                .role(userInfoJoinRequestDto.getRole())
                .build();
        userInfoRepository.save(userInfo);

        return userInfo;
    }

    @Override
    public UserInfo getUser(UserInfoLoginRequestDto userInfoLoginRequestDto) {

        String id = userInfoLoginRequestDto.getName();
        String password = userInfoLoginRequestDto.getPassword();

        return userInfoRepository.findByNameAndPassword(id,password);
    }


}
