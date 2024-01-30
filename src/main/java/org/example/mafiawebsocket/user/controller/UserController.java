package org.example.mafiawebsocket.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>("hi", HttpStatus.OK);
    }

}
