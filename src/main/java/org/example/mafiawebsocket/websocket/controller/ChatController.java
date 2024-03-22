package org.example.mafiawebsocket.websocket.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.mafiawebsocket.websocket.dto.ChatRoom;
import org.example.mafiawebsocket.websocket.service.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService service;

    @PostMapping
    public ChatRoom createRoom(@RequestBody String name){
        return service.createRoom(name);
    }

    @GetMapping
    public List<ChatRoom> findAllRooms(){
        return service.findAllRoom();
    }
}

