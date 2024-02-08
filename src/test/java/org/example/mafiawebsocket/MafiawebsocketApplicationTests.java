package org.example.mafiawebsocket;

import jakarta.transaction.Transactional;
import org.example.mafiawebsocket.commonutil.ShaUtil;
import org.example.mafiawebsocket.user.dto.UserInfoJoinRequestDto;
import org.example.mafiawebsocket.user.entity.UserInfo;
import org.example.mafiawebsocket.user.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class MafiawebsocketApplicationTests {

	@Autowired
	private  UserInfoService userInfoService;

	@Autowired
	private PasswordEncoder passwordEncoder;
    @Test
	void contextLoads() {
	}

	@Test
//	@Transactional()
	void testCreateUser(){
		UserInfoJoinRequestDto userInfoJoinRequestDto = new UserInfoJoinRequestDto();
		ShaUtil shaUtil = new ShaUtil();
		userInfoJoinRequestDto.setName("test1");
		userInfoJoinRequestDto.setPassword("1234");

		UserInfo user =userInfoService.createUser(userInfoJoinRequestDto);
	}

	@Test
	void getUser(){

	}
}
