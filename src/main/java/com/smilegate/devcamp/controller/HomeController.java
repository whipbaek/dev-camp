package com.smilegate.devcamp.controller;

import com.smilegate.devcamp.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/devcamp")
public class HomeController {
    @GetMapping
    public String home(@SessionAttribute(name="LoginSession", required = false)Member loginMember, Model model) {

        if (loginMember == null) {
            return "home";
        }

        model.addAttribute("loginMember", loginMember);
        return "loginHome";
    }
}
