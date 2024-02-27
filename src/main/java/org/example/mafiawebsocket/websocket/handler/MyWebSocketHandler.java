package org.example.mafiawebsocket.websocket.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        // 메시지 처리 로직 구현
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        // 웹소켓 연결이 수립되면 호출되는 메서드
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        // 웹소켓 연결이 종료되면 호출되는 메서드
    }
}
