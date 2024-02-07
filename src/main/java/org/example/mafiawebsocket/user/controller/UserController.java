package org.example.mafiawebsocket.user.controller;

import org.example.mafiawebsocket.user.dto.UserInfoJoinRequestDto;
import org.example.mafiawebsocket.user.dto.UserInfoLoginRequestDto;
import org.example.mafiawebsocket.user.dto.UserInfoResponseDto;
import org.example.mafiawebsocket.user.entity.UserInfo;
import org.example.mafiawebsocket.user.service.UserInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserInfoService userInfoService;

    public UserController(UserInfoService userInfoService){
        this.userInfoService = userInfoService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>("hi", HttpStatus.OK);
    }

    @PostMapping("/join")
    public ResponseEntity<?> createUsers(@RequestBody UserInfoJoinRequestDto userInfoJoinRequestDto){

        UserInfo userInfo = userInfoService.createUser(userInfoJoinRequestDto);
        UserInfoResponseDto userInfoResponseDto = new UserInfoResponseDto(userInfo);
        return new ResponseEntity<>(userInfoResponseDto,HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserInfoLoginRequestDto userInfoLoginRequestDto){

        UserInfo userInfo = userInfoService.getUser(userInfoLoginRequestDto);

        return new ResponseEntity<>(userInfo,HttpStatus.OK);
    }

}
