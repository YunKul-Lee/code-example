package com.jake.websocket.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatMessage {

    private String content;
    private String sender;
    private LocalDateTime timestamp;
}
