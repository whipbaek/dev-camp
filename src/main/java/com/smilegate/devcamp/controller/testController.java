package com.smilegate.devcamp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class testController {
    @GetMapping("/test")
    public List<String> test() {
        return Arrays.asList("서버 포트는 8080", "리액트 포트는 3000");
    }
}
