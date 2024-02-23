package org.example.mafiawebsocket.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoJoinRequestDto {

    private String username;
    private String password;
    private String role;
}
