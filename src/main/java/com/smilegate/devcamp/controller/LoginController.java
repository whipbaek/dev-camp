package com.smilegate.devcamp.controller;

import com.smilegate.devcamp.dto.MemberLoginDto;
import com.smilegate.devcamp.entity.Member;
import com.smilegate.devcamp.repository.MemberEntityRepository;
import com.smilegate.devcamp.repository.MemberRepository;
import com.smilegate.devcamp.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import static com.smilegate.devcamp.config.Const.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(BASIC_URL)
public class LoginController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login(@ModelAttribute("memberLoginDto")MemberLoginDto memberLoginDto) {
        return "login";
    }

    @PostMapping("/login")
    public String loginTry(@ModelAttribute("memberLoginDto") @Valid MemberLoginDto memberLoginDto, BindingResult bindingResult, HttpServletRequest request,
                           @RequestParam(defaultValue = BASIC_URL) String redirectURL) {
        if (bindingResult.hasErrors()) {
            log.error("[Register] Some fields are Empty!");
            return "login";
        }

        Member loginMember = memberService.login(memberLoginDto);
        if(loginMember == null){
            bindingResult.reject( "mismatch", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login";
        }

        // Login Success logic
        HttpSession session = request.getSession();
        session.setAttribute("LoginSession", loginMember);

        return "redirect:" + redirectURL;
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/devcamp";
    }


}
