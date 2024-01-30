package org.example.mafiawebsocket.user.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserInfoResponseDto {

    private UUID uuid;
    private String name;
    private String password;
}
