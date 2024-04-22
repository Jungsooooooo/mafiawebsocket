package org.example.mafiawebsocket.websocket.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.example.mafiawebsocket.websocket.service.ChatService;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
public class ChatRoom {
    private String roomId; // 채팅방 아이디
    private String name; // 채팅방 이름
    private String owner;
    private String status;
    private Set<String> sessions = new HashSet<>();

    @Builder
    public ChatRoom(String roomId, String name, String owner, String status){
        this.roomId = roomId;
        this.name   = name;
        this.owner  = owner;
        this.status = status;
    }

    public void handleAction(WebSocketSession session, ChatDTO message, ChatService service) {
        // message 에 담긴 타입을 확인한다.
        // 이때 message 에서 getType 으로 가져온 내용이
        // ChatDTO 의 열거형인 MessageType 안에 있는 ENTER 과 동일한 값이라면
        if (message.getType().equals(ChatDTO.MessageType.ENTER)) {
            // sessions 에 넘어온 session 을 담고,

            sessions.add(session.getId());
//            service.findRoomById();
            ChatRoom c = service.findRoomById(message.getRoomId());

            c.setSessions(sessions);
            // message 에는 입장하였다는 메시지를 띄운다
//            sessions.removeIf(sessionCheck -> sessionCheck == null);
//            service.addSessionRoom(message.getRoomId(),session);
            message.setMessage(message.getSender() + " 님이 입장하셨습니다");
            sendMessage(session,message, service);
        } else if (message.getType().equals(ChatDTO.MessageType.TALK)) {
            message.setMessage(message.getMessage());
            sendMessage(session,message, service);
        }
    }

    public <T> void sendMessage(WebSocketSession session ,T message, ChatService service ) {
        service.sendMessage(session, message);
    }
}

