package com.smilegate.devcamp.controller;

import com.smilegate.devcamp.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/devcamp")
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/home")
    public String register(@Valid Member member){
        return null;
    }
}
