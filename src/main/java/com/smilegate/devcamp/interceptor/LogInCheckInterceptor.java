package com.smilegate.devcamp.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.smilegate.devcamp.config.Const.BASIC_URL;
import static com.smilegate.devcamp.config.Const.LOGIN_SESSION;

@Slf4j
public class LogInCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        log.info("로그인 인증 인터셉터 실행 {}", requestURI);

        //세션이 있으면 반환
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute(LOGIN_SESSION) == null){
            log.info("로그인 되어 있지 않습니다.");
            response.sendRedirect(BASIC_URL);
            return false;
        }

        return true;
    }
}
