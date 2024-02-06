package org.example.mafiawebsocket;

import org.example.mafiawebsocket.user.dto.UserInfoJoinRequestDto;
import org.example.mafiawebsocket.user.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
public class JunitTest {

    @Autowired
    private  UserInfoService userInfoService;

    @Test
    void myTest(){

        UserInfoJoinRequestDto userInfoJoinRequestDto = new UserInfoJoinRequestDto();
        userInfoJoinRequestDto.setName("test");

        userInfoService.createUser(userInfoJoinRequestDto);
        System.out.println("hi");
    }
}
