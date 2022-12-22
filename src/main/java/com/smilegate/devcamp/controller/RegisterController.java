package com.smilegate.devcamp.controller;

import com.smilegate.devcamp.dto.MemberDto;
import com.smilegate.devcamp.entity.Member;
import com.smilegate.devcamp.service.EmailService;
import com.smilegate.devcamp.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/devcamp")
public class RegisterController {

    private final MemberService memberService;
    private final EmailService emailService;
    private MemberDto serverMemberDto;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String makeAccount(@Valid @ModelAttribute MemberDto memberDto) {
        log.info("가입 정보 : {}", memberDto);
        memberService.validateDuplicatedEmail(memberDto);
        serverMemberDto = new MemberDto(memberDto);
        emailService.sendSimpleMessage(serverMemberDto.getEmail());
        return "redirect:/devcamp/email";
    }

    @GetMapping("/email")
    public String emailConfirm(){
        return "emailConfirm";
    }

    @PostMapping("/email")
    public String checkCodeNumber(@RequestParam(value = "emailNumber") String emailNumber){

        if (emailService.validateCodeNumber(emailNumber)) {
            memberService.join(serverMemberDto);
        }
        return "redirect:/devcamp/email/success";
    }

    @GetMapping("/email/success")
    public String registerSuccess(){
        return "registerSuccess";
    }
}
