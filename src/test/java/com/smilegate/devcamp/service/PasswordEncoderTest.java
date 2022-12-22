package com.smilegate.devcamp.service;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Slf4j
public class PasswordEncoderTest {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("패스워드 암호화 테스트")
    void passwordEncode(){
        // given
        String originalPw = "ab1234";

        // when
        String encodedPw = passwordEncoder.encode(originalPw);

        // then
        assertThat(originalPw).isNotEqualTo(encodedPw);

    }

}
