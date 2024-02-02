package org.example.mafiawebsocket;

import org.example.mafiawebsocket.user.dto.UserInfoJoinRequestDto;
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
	void test123(){
		UserInfoJoinRequestDto userInfoJoinRequestDto = new UserInfoJoinRequestDto();
		userInfoJoinRequestDto.setName("test");

		userInfoService.createUser(userInfoJoinRequestDto);
		System.out.println("hi");
	}


}
