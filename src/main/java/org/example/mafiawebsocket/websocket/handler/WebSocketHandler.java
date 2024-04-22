package org.example.mafiawebsocket.websocket.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.mafiawebsocket.websocket.dto.ChatDTO;
import org.example.mafiawebsocket.websocket.dto.ChatRoom;
import org.example.mafiawebsocket.websocket.service.ChatService;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {

    private final ObjectMapper mapper;

    private final ChatService service;

    private static final ConcurrentHashMap<String, WebSocketSession> CLIENTS = new ConcurrentHashMap<String, WebSocketSession>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        CLIENTS.put(session.getId(), session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        CLIENTS.remove(session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();

//        TextMessage textMessage = new TextMessage("Welcome Chatting Server");
//        session.sendMessage(textMessage);

        ChatDTO chatMessage = mapper.readValue(payload, ChatDTO.class);

        ChatRoom room = service.findRoomById(chatMessage.getRoomId());
        room.handleAction(session, chatMessage, service);
    }
}