package org.example.mafiawebsocket.websocket.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.mafiawebsocket.websocket.dto.ChatDTO;
import org.example.mafiawebsocket.websocket.dto.ChatRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
        int page = 0;
        int size = 1;
        PageRequest pageRequest = PageRequest.of(page, size);

        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), chatRoomAll.size());

        Page<ChatRoom> test = new PageImpl<>(chatRoomAll.subList(start,end),pageRequest,chatRoomAll.size());
        List<ChatRoom> chatWaitingRoomAll = new ArrayList<>();
        for (ChatRoom chatRoom : chatRoomAll) {
                if (chatRoom.getStatus().equals(status)) {
                    chatWaitingRoomAll.add(chatRoom);
                }
            }

        return chatWaitingRoomAll;
    }

    public ChatRoom findRoomById(String roomId){

        List<ChatRoom> chatRoomAll = new ArrayList<ChatRoom>(chatRooms.values());

        List<ChatRoom> chatWaitingRoomAll = new ArrayList<>();

        return chatRooms.get(roomId);
    }

    public ChatRoom createRoom(ChatRoom chatRoom) {
        String roomId = UUID.randomUUID().toString(); // 랜덤한 방 아이디 생성

        // Builder 를 이용해서 ChatRoom 을 Building
        ChatRoom room = ChatRoom.builder()
                .roomId(roomId)
                .name(chatRoom.getName())
                .owner(chatRoom.getOwner())
                .status("waiting")
                .build();

        chatRooms.put(roomId, room); // 랜덤 아이디와 room 정보를 Map 에 저장

        return room;
    }

    public void
    deleteRoom(String roomId){

        List<ChatRoom> chatRoomAll = new ArrayList<ChatRoom>(chatRooms.values());

//        chatRooms.remove(roomId);
        ChatRoom cr = chatRooms.get(roomId);

        chatRooms.remove(roomId);
//        chatRooms.
    }

    public ChatRoom updateRoom(String roomId){

//        chatRooms.remove(roomId);
        ChatRoom cr = chatRooms.get(roomId);

        cr.setStatus("start");
        return cr;
    }

    public <T> void sendMessage(WebSocketSession session, T message,  ChatRoom c) {
        try{
            chatRooms.put(c.getRoomId(), c);
            session.sendMessage(new TextMessage(mapper.writeValueAsString(message)));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
