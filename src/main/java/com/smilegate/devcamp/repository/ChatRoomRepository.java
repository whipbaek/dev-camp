package com.smilegate.devcamp.repository;

import com.smilegate.devcamp.dto.chat.ChatRoomDto;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ChatRoomRepository {

    private Map<String, ChatRoomDto> chatRoomDtoMap;

    @PostConstruct
    private void init(){
        chatRoomDtoMap = new LinkedHashMap<>();
    }

    public List<ChatRoomDto> findAllRooms() {
        List<ChatRoomDto> result = new ArrayList<>(chatRoomDtoMap.values());
        Collections.reverse(result);
        return result;
    }

    public ChatRoomDto findRoomById(String id) {
        return chatRoomDtoMap.get(id);
    }

    public ChatRoomDto createChatRoomDto(String name) {
        ChatRoomDto roomDto = ChatRoomDto.create(name);
        chatRoomDtoMap.put(roomDto.getRoomId(), roomDto);
        return roomDto;
    }
}
