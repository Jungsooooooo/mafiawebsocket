package org.example.mafiawebsocket.websocket.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.mafiawebsocket.websocket.dto.ChatDTO;
import org.example.mafiawebsocket.websocket.dto.ChatRoom;
import org.example.mafiawebsocket.websocket.service.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService service;

    @PostMapping
    public ChatRoom createRoom(@RequestBody ChatRoom chatRoom){
        return service.createRoom(chatRoom);
    }

    @PostMapping("/delete")
    public void deleteRoom(@RequestBody ChatDTO chatDTO){
         service.deleteRoom(chatDTO.getRoomId());
    }

    @PostMapping("/start")
    public ChatRoom startRoom(@RequestBody ChatDTO chatDTO){
       return service.updateRoom(chatDTO.getRoomId());
    }

    @GetMapping
    public ResponseEntity<?> findAllRooms(){

        return new ResponseEntity<>( service.findWaitingAllRoom("waiting"), HttpStatus.OK);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<?> findRoomById(@PathVariable String roomId){
        return new ResponseEntity<>( service.findRoomById(roomId), HttpStatus.OK);
    }
}

