package com.smilegate.devcamp.controller;

import com.smilegate.devcamp.dto.MemberDto;
import com.smilegate.devcamp.entity.Member;
import com.smilegate.devcamp.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/devcamp")
public class RegisterController {

    private final MemberService memberService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String makeAccount(@Valid @ModelAttribute MemberDto memberDto) {
        log.info("{}", memberDto);
//        memberService.join(memberDto);
        log.info("계정 생성 완료");
        return "redirect:/devcamp";
    }
}
