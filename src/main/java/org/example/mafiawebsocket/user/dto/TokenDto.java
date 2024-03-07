package org.example.mafiawebsocket.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {

    private String token;
    private String username;
    private String uuid;

    public TokenDto(String jwt, UserInfoResponseDto loginDto) {
        this.token       = jwt;
        this.username    = loginDto.getUsername();

    }
}
