package com.smilegate.devcamp.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private String authCode;

    public String makeAuthCode(){
        Random random = new Random();
        StringBuffer tempCode = new StringBuffer();
        for(int i=0; i<7; i++){
            tempCode.append(random.nextInt(10));
        }
        authCode = tempCode.toString();
        return authCode;
    }

    public void sendSimpleMessage(String email) {
        System.out.println("email = " + email);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("whipbaek@gmail.com");
        message.setTo(email);
        message.setSubject("Winter Authentication 인증 메일입니다.");
        message.setText("❄⛄ 인증코드는 " + makeAuthCode() + " 입니다. ");
        javaMailSender.send(message);
    }

    public boolean validateCodeNumber(String emailNumber) {
        System.out.println("emailNumber = " + emailNumber);
        System.out.println("authCode = " + authCode);
        if(emailNumber.equals(authCode)){
            return true;
        }
        return false;
    }

}
