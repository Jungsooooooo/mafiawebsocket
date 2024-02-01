package org.example.mafiawebsocket.user.dto;

import lombok.Getter;

@Getter
public class UserInfoJoinRequestDto {

    private String name;
    private String password;
    private String role;
}
