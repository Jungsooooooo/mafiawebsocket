package org.example.mafiawebsocket.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private UUID uuid;

    private String username;
    private String password;
    private String role;

    @JsonIgnore
    private boolean activated;

    @Builder
    public User(String name, String password, String role){
        this.username       = name;
        this.password   = password;
        this.uuid       = UUID.randomUUID();

        if(role == null){
            this.role = "normal_user";
        } else {
            this.role = null;
        }
    }

}
