package org.example.mafiawebsocket.user.entity;

import ch.qos.logback.classic.spi.LoggingEventVO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@Table(name = "userInfo")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private UUID uuid;

    private String name;
    private String password;

    @Builder
    public UserInfo(String name, String password){
        this.name       = name;
        this.password   = password;
        this.uuid       = UUID.randomUUID();
    }

}
