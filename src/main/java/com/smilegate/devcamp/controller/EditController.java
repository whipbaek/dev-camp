package com.smilegate.devcamp.controller;

import com.smilegate.devcamp.dto.MemberDto;
import com.smilegate.devcamp.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static com.smilegate.devcamp.config.Const.*;

@Slf4j
@Controller
@RequestMapping(BASIC_URL)
public class EditController {
    @GetMapping("/edit")
    public String editEnter(@SessionAttribute(name=LOGIN_SESSION, required = false) Member loginMember, Model model){

        System.out.println("loginEmail = " + loginMember.getEmail());

        model.addAttribute(new MemberDto(loginMember));

        return "edit";
    }

//    @PostMapping("/edit")
//    public String edit(@ModelAttribute MemberDto memberDto, BindingResult bindingResult){
//        //비밀번호 길이 검사
//        if(memberDto.getPassword().length() < 6){
//            bindingResult.rejectValue("password", "length", "비밀번호 길이는 6자 이상이어야합니다.");
//            return "register";
//        }
//
//        //이름 길이 검사
//        if(memberDto.getName().length() < 2){
//            bindingResult.rejectValue("name", "length", "이름은 2자 이상이어야합니다.");
//            return "register";
//        }
//    }
}
