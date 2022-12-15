package com.smilegate.devcamp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
