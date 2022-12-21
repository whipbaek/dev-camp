package com.smilegate.devcamp.service;

import com.smilegate.devcamp.dto.MemberDto;
import com.smilegate.devcamp.entity.Member;
import com.smilegate.devcamp.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional //Data RollBack 해준다.
public class MemberServiceTest {
    //@Autowired 로 빈에게 의존성 주입
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입 테스트 입니다.")
    public void 회원가입() {
        //given -> 멤버가 주어짐
        MemberDto memberdto = new MemberDto("whipbaek@gmail.com", "tempPassword", "whipbaek");

        //when -> 가입하면
        Long count = memberService.join(memberdto);
        System.out.println("count = " + count);

        //then -> DB 접근하여 id 값이 같은지 확인해보자 (dto를 거치므로 객체는 다르게 저장됨)
        assertThat(memberdto.getId()).isEqualTo(memberRepository.findOne(count).getId());

    }
}
