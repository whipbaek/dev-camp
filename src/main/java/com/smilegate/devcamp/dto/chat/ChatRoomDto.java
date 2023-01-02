package com.smilegate.devcamp.dto.chat;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ChatRoomDto {
    private String roomId;
    private String name;

    public static ChatRoomDto create(String name) {
        ChatRoomDto room = new ChatRoomDto();

        room.setRoomId(UUID.randomUUID().toString());
        room.setName(name);
        return room;
    }
}
