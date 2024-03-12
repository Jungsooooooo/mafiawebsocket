package org.example.mafiawebsocket.user.service.impl;

import org.example.mafiawebsocket.commonutil.ShaUtil;
import org.example.mafiawebsocket.user.dto.UserInfoJoinRequestDto;
import org.example.mafiawebsocket.user.dto.UserInfoLoginRequestDto;
import org.example.mafiawebsocket.user.entity.User;
import org.example.mafiawebsocket.user.repository.UserInfoRepository;
import org.example.mafiawebsocket.user.service.UserInfoService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public User createUser(UserInfoJoinRequestDto userInfoJoinRequestDto) {
        ShaUtil shaUtil = new ShaUtil();
        String pwd = passwordEncoder.encode(userInfoJoinRequestDto.getPassword());
        User userInfo = User.builder().name(userInfoJoinRequestDto.getUsername())
                .password(passwordEncoder.encode(userInfoJoinRequestDto.getPassword()))
                .role(userInfoJoinRequestDto.getRole())
                .build();
        userInfoRepository.save(userInfo);

        return userInfo;
    }

    @Override
    public Optional<User> getUser(UserInfoLoginRequestDto userInfoLoginRequestDto) {
        String id = userInfoLoginRequestDto.getUsername();
        String password = passwordEncoder.encode(userInfoLoginRequestDto.getPassword());

        boolean passwordMatches = passwordEncoder.matches(userInfoLoginRequestDto.getPassword(), password);

        if(passwordMatches){
            Optional<User> userCheck = userInfoRepository.findByUsername(id);
            return userCheck;
        } else {
            return Optional.empty();
        }

    }

    @Override
    public Boolean checkUserId(UserInfoJoinRequestDto userInfoJoinRequestDto) {

        String id = userInfoJoinRequestDto.getUsername();

        Optional<User> userCheck = userInfoRepository.findByUsername(id);

        boolean checkId = false;
        if(!userCheck.isEmpty()){
            checkId  = true;
        }

        return checkId;
    }


}
