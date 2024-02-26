package org.example.mafiawebsocket.user.service;

import jakarta.jws.soap.SOAPBinding;
import org.example.mafiawebsocket.user.dto.UserInfoJoinRequestDto;
import org.example.mafiawebsocket.user.dto.UserInfoLoginRequestDto;
import org.example.mafiawebsocket.user.entity.User;

import java.util.Optional;

public interface UserInfoService {

    public User createUser(UserInfoJoinRequestDto userInfoJoinRequestDto);

    public Optional<User> getUser(UserInfoLoginRequestDto userInfoLoginRequestDto);
}
