package com.smilegate.devcamp.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional //Data RollBack 해준다.
@Slf4j
public class EmailServiceTest {

    @Autowired
    EmailService emailService;

    @Test
    public void 난수생성테스트(){
        String authCode = emailService.makeAuthCode();
        log.info("random Num : {}", authCode);
        assertThat(authCode.length()).isEqualTo(7);
    }
}
