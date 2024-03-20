package org.example.mafiawebsocket.user.controller;

import org.example.mafiawebsocket.user.dto.UserInfoJoinRequestDto;
import org.example.mafiawebsocket.user.dto.UserInfoLoginRequestDto;
import org.example.mafiawebsocket.user.dto.UserInfoResponseDto;
import org.example.mafiawebsocket.user.entity.User;
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
    public ResponseEntity<?> createUsers(@RequestBody UserInfoJoinRequestDto userInfoJoinRequestDto) throws Exception{

        User userInfo = null;
        try {
             userInfo = userInfoService.createUser(userInfoJoinRequestDto);
        } catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        UserInfoResponseDto userInfoResponseDto = new UserInfoResponseDto(userInfo);
        return new ResponseEntity<>(userInfoResponseDto, HttpStatus.OK);
    }

    @PostMapping("/checkid")
    public ResponseEntity<?> checkId(@RequestBody UserInfoJoinRequestDto userInfoJoinRequestDto){

        boolean checkId = userInfoService.checkUserId(userInfoJoinRequestDto);

        return new ResponseEntity<>(checkId,HttpStatus.OK);
    }


}
