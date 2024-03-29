package org.example.mafiawebsocket.websocket.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.mafiawebsocket.websocket.dto.ChatRoom;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.*;

@Slf4j
@Data
@Service
public class ChatService {
    private final ObjectMapper mapper;
    private Map<String, ChatRoom> chatRooms;

    @PostConstruct
    private void init() {
        chatRooms = new LinkedHashMap<>();
    }

    public List<ChatRoom> findAllRoom(){
        return new ArrayList<>(chatRooms.values());
    }

    public List<ChatRoom> findWaitingAllRoom(String status){

        List<ChatRoom> chatRoomAll = new ArrayList<>(chatRooms.values());

        List<ChatRoom> chatWaitingRoomAll = new ArrayList<>();
        for (ChatRoom chatRoom : chatRoomAll) {
                if (chatRoom.getStatus().equals("wait")) {
                    chatWaitingRoomAll.add(chatRoom);
                }
            }

        return chatWaitingRoomAll;
    }

    public ChatRoom findRoomById(String roomId){

        List<ChatRoom> chatRoomAll = new ArrayList<ChatRoom>(chatRooms.values());

        List<ChatRoom> chatWaitingRoomAll = new ArrayList<>();
        chatRoomAll.removeIf(chatRoom -> chatRoom.getRoomId().equals(roomId));

        return chatRooms.get(roomId);
    }

    public ChatRoom createRoom(String name,String owner) {
        String roomId = UUID.randomUUID().toString(); // 랜덤한 방 아이디 생성

        // Builder 를 이용해서 ChatRoom 을 Building
        ChatRoom room = ChatRoom.builder()
                .roomId(roomId)
                .name(name)
                .owner(owner)
                .build();

        chatRooms.put(roomId, room); // 랜덤 아이디와 room 정보를 Map 에 저장

        return room;
    }

    public void
    deleteRoom(String roomId){

        List<ChatRoom> chatRoomAll = new ArrayList<ChatRoom>(chatRooms.values());

        chatRooms.remove(roomId);

//        chatRooms.
    }

    public <T> void sendMessage(WebSocketSession session, T message) {
        try{
            session.sendMessage(new TextMessage(mapper.writeValueAsString(message)));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
