package com.smilegate.devcamp.controller.chat;

import com.smilegate.devcamp.dto.chat.ChatMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class StompChatController {

    private final SimpMessageSendingOperations simpMessageSendingOperations;

    @MessageMapping("/chat/enter")
    public void enter(ChatMessageDto message) {
        message.setMessage(message.getWriter() + " 님이 들어왔습니다.");
        message.setWriter("system");
        simpMessageSendingOperations.
                convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

    @MessageMapping("/chat/message")
    public void message(ChatMessageDto message){
        simpMessageSendingOperations
                .convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}
