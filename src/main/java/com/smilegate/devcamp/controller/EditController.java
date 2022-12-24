package com.smilegate.devcamp.controller;

import com.smilegate.devcamp.dto.MemberDto;
import com.smilegate.devcamp.entity.Member;
import com.smilegate.devcamp.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static com.smilegate.devcamp.config.Const.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(BASIC_URL)
public class EditController {

    private final MemberService memberService;

    @GetMapping("/edit")
    public String editEnter(@SessionAttribute(name=LOGIN_SESSION, required = false) Member loginMember, Model model){

        System.out.println("loginEmail = " + loginMember.getEmail());

        model.addAttribute(new MemberDto(loginMember));

        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute MemberDto memberDto, BindingResult bindingResult){

        // 바인딩 에러
        if (bindingResult.hasErrors()) {
            log.error("[Register] Some fields are Empty!");
            return "edit";
        }

        //비밀번호 길이 검사
        if(memberDto.getPassword().length() < 6){
            bindingResult.rejectValue("password", "length", "비밀번호 길이는 6자 이상이어야합니다.");
            return "edit";
        }

        //이름 길이 검사
        if(memberDto.getName().length() < 2){
            bindingResult.rejectValue("name", "length", "이름은 2자 이상이어야합니다.");
            return "edit";
        }

        memberService.editMemberInfo(memberDto);

        return "redirect:/devcamp";
    }

}
