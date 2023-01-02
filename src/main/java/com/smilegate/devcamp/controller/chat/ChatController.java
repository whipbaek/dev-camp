package com.smilegate.devcamp.controller.chat;

import com.smilegate.devcamp.entity.Member;
import com.smilegate.devcamp.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.smilegate.devcamp.config.Const.BASIC_URL;
import static com.smilegate.devcamp.config.Const.LOGIN_SESSION;

@Controller
@RequiredArgsConstructor
@RequestMapping(BASIC_URL + "/chat")
@Slf4j
public class ChatController {

    private final ChatRoomRepository repository;


    // 모든 채팅방 목록 반환
    @GetMapping("/rooms")
    public String rooms(@SessionAttribute(name=LOGIN_SESSION, required = false) Member loginMember, Model model) {

        log.info("loginMember : {}", loginMember.getName() );

        log.info("rooms 페이지 진입");
        model.addAttribute("loginMember", loginMember);
        model.addAttribute("list", repository.findAllRooms());
        log.info("rooms 페이지 모델 얻어옴");
        return "chatRooms";
    }

    //RedirectAttributes -> redirect 하면서 model 을 넘기는 객체
    @PostMapping("/rooms")
    public String create(@RequestParam String name, RedirectAttributes rttr){
        log.info("채팅방 생성 로직 실행!");
        rttr.addFlashAttribute("roomName", repository.createChatRoomDto(name));
        log.info("메세지 전송! , redirect!");
        return "redirect:rooms";
    }

    @GetMapping("/room")
    public String getRoom(@SessionAttribute(name=LOGIN_SESSION, required = false) Member loginMember, String roomId, Model model) {
        model.addAttribute("loginMember", loginMember);
        model.addAttribute("room", repository.findRoomById(roomId));
        return "chatRoom";
    }
}
