package org.example.mafiawebsocket;

import jakarta.transaction.Transactional;
import org.example.mafiawebsocket.user.dto.UserInfoJoinRequestDto;
import org.example.mafiawebsocket.user.entity.UserInfo;
import org.example.mafiawebsocket.user.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MafiawebsocketApplicationTests {

	@Autowired
	private  UserInfoService userInfoService;
    @Test
	void contextLoads() {
	}

	@Test
	@Transactional
	void testCreateUser(){
		UserInfoJoinRequestDto userInfoJoinRequestDto = new UserInfoJoinRequestDto();
		userInfoJoinRequestDto.setName("test");

		UserInfo user =userInfoService.createUser(userInfoJoinRequestDto);
	}
}
