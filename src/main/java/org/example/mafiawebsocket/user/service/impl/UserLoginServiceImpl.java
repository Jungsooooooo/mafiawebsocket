package org.example.mafiawebsocket.user.service.impl;

import org.example.mafiawebsocket.commonutil.ShaUtil;
import org.example.mafiawebsocket.user.entity.UserInfo;
import org.example.mafiawebsocket.user.repository.UserInfoRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserDetailsService {

    private final UserInfoRepository userInfoRepository;
    private final PasswordEncoder passwordEncoder;


    public UserLoginServiceImpl(UserInfoRepository userInfoRepository,
                                PasswordEncoder passwordEncoder) {
        this.userInfoRepository = userInfoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        UserInfo userInfo = userInfoRepository.findByName("test1");

        return toUserDetail(userInfo);
    }

    private UserDetails toUserDetail(UserInfo userInfo) {
        ShaUtil shaUtil = new ShaUtil();
        return User.builder()
                .username(userInfo.getName())
                .password(userInfo.getPassword())
                .authorities(new SimpleGrantedAuthority("ROLE_USER"))
                .build();
    }

}

