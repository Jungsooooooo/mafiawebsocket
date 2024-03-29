package org.example.mafiawebsocket.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    private Long id;

    private UUID uuid;

    @NotNull
    private String username;

    @NotNull
    private String password;

    private String role;

    @JsonIgnore
    private boolean activated;

    @Builder
    public User(String name, String password, String role){
        this.username       = name;
        this.password   = password;
        this.uuid       = UUID.randomUUID();
        this.activated  = true;
        if(role == null){
            this.role = "normal_user";
        } else {
            this.role = null;
        }
    }

}
