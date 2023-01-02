package com.smilegate.devcamp.config;

import com.smilegate.devcamp.dto.MemberDto;
import com.smilegate.devcamp.entity.Member;
import com.smilegate.devcamp.repository.MemberEntityRepository;
import com.smilegate.devcamp.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class DbInit {

    private final MemberService memberService;

    @PostConstruct
    public void init() {
        memberService.join(new MemberDto("whipbaek@gmail.com","whddls12","백종인"));
        memberService.join(new MemberDto("jibaek0513@gmail.com","whddls12","김종인"));
    }
}
