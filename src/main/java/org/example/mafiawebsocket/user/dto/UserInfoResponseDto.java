package org.example.mafiawebsocket.user.dto;

import lombok.Getter;
import org.example.mafiawebsocket.user.entity.UserInfo;

import java.util.UUID;

@Getter
public class UserInfoResponseDto {

    private UUID uuid;
    private String name;
    private String role;

    public UserInfoResponseDto(UserInfo userInfo) {
        this.uuid = userInfo.getUuid();
        this.name = userInfo.getName();
        this.role = userInfo.getRole();
    }
}
