package org.example.mafiawebsocket.user.service.impl;

import org.example.mafiawebsocket.commonutil.ShaUtil;
import org.example.mafiawebsocket.user.dto.UserInfoJoinRequestDto;
import org.example.mafiawebsocket.user.dto.UserInfoLoginRequestDto;
import org.example.mafiawebsocket.user.entity.UserInfo;
import org.example.mafiawebsocket.user.repository.UserInfoRepository;
import org.example.mafiawebsocket.user.service.UserInfoService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final PasswordEncoder passwordEncoder;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository,
                               PasswordEncoder passwordEncoder){
        this.userInfoRepository = userInfoRepository;
        this.passwordEncoder    = passwordEncoder;

    }

    @Override
    public UserInfo createUser(UserInfoJoinRequestDto userInfoJoinRequestDto) {
        ShaUtil shaUtil = new ShaUtil();
        String pwd = passwordEncoder.encode(userInfoJoinRequestDto.getPassword());
        UserInfo userInfo = UserInfo.builder().name(userInfoJoinRequestDto.getName())
                .password(passwordEncoder.encode(userInfoJoinRequestDto.getPassword()))
                .role(userInfoJoinRequestDto.getRole())
                .build();
        userInfoRepository.save(userInfo);

        return userInfo;
    }

    @Override
    public UserInfo getUser(UserInfoLoginRequestDto userInfoLoginRequestDto) {
        ShaUtil shaUtil = new ShaUtil();
        String id = userInfoLoginRequestDto.getUsername();
        String password = passwordEncoder.encode(userInfoLoginRequestDto.getPassword());

        return userInfoRepository.findByNameAndPassword(id,password);
    }


}
