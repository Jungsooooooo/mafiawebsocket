package org.example.mafiawebsocket.user.service.impl;

import org.example.mafiawebsocket.user.entity.UserInfo;
import org.example.mafiawebsocket.user.repository.UserInfoRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserDetailsService {

    private final UserInfoRepository userInfoRepository;

    public UserLoginServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = userInfoRepository.findByName(username);

        return toUserDetail(userInfo);
    }

    private UserDetails toUserDetail(UserInfo userInfo) {
        return User.builder()
                .username(userInfo.getName())
                .password(userInfo.getPassword())
                .authorities(new SimpleGrantedAuthority(userInfo.getRole()))
                .build();
    }

}

