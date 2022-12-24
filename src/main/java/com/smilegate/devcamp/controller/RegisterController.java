package com.smilegate.devcamp.controller;

import com.smilegate.devcamp.dto.EmailDto;
import com.smilegate.devcamp.dto.MemberDto;
import com.smilegate.devcamp.entity.Member;
import com.smilegate.devcamp.service.EmailService;
import com.smilegate.devcamp.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import static com.smilegate.devcamp.config.Const.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(BASIC_URL)
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
    public String emailConfirm(@ModelAttribute(value = "emailDto") EmailDto emailDto){
        return "emailConfirm";
    }

    @PostMapping("/email")
    public String checkCodeNumber(@ModelAttribute(value = "emailDto") EmailDto emailDto, BindingResult bindingResult){

        System.out.println("post 호출");
        if (emailService.validateCodeNumber(emailDto.getCodeNumber())) {
            memberService.join(serverMemberDto);
        } else{
            System.out.println("코드가 맞지않아요");
            bindingResult.reject("mismatch", "코드가 맞지 않습니다.");
            System.out.println("bindingResult = " + bindingResult);
            return "emailConfirm";
        }
        return "redirect:/devcamp/email/success";
    }

    @GetMapping("/email/success")
    public String registerSuccess(){
        return "registerSuccess";
    }
}
