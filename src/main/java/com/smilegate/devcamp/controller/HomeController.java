package com.smilegate.devcamp.controller;

import com.smilegate.devcamp.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/devcamp")
public class HomeController {
    @GetMapping
    public String home() {
        return "home";
    }

    @PostMapping()
    public String register(@Valid Member member){
        return null;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
