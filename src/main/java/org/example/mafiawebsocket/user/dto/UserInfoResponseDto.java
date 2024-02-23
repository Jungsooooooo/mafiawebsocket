package org.example.mafiawebsocket.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.mafiawebsocket.user.entity.User;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class UserInfoResponseDto {

    private UUID uuid;
    private String name;
    private String role;

    public UserInfoResponseDto(User user) {
        this.uuid = user.getUuid();
        this.name = user.getUsername();
        this.role = user.getRole();
    }
}
