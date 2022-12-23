package com.smilegate.devcamp.controller;

import com.smilegate.devcamp.dto.MemberDto;
import com.smilegate.devcamp.entity.Member;
import com.smilegate.devcamp.service.EmailService;
import com.smilegate.devcamp.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
    public String register(@ModelAttribute("memberDto") MemberDto memberDto) {
        return "register";
    }

    @PostMapping("/register")
    public String makeAccount(@ModelAttribute("memberDto") @Valid MemberDto memberDto, BindingResult bindingResult) {

        // 바인딩 에러
        if (bindingResult.hasErrors()) {
            log.error("[Register] Some fields are Empty!");
            return "register";
        }
        // 이메일 중복 검사
        boolean exist = memberService.validateDuplicatedEmail(memberDto);
        if (exist) {
            bindingResult.rejectValue("email", "duplicate", "해당 메일은 이미 가입된 메일입니다.");
            return "register";
        }

        //비밀번호 길이 검사
        if(memberDto.getPassword().length() < 6){
            bindingResult.rejectValue("password", "length", "비밀번호 길이는 6자 이상이어야합니다.");
            return "register";
        }

        //이름 길이 검사
        if(memberDto.getName().length() < 2){
            bindingResult.rejectValue("name", "length", "이름은 2자 이상이어야합니다.");
            return "register";
        }

        log.info("가입 정보 : {}", memberDto);

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
