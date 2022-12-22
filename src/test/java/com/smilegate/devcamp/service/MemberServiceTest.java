package com.smilegate.devcamp.service;

import com.smilegate.devcamp.dto.MemberDto;
import com.smilegate.devcamp.dto.MemberLoginDto;
import com.smilegate.devcamp.repository.MemberEntityRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional //Data RollBack 해준다.
public class MemberServiceTest {
    //@Autowired 로 빈에게 의존성 주입
    @Autowired MemberService memberService;
    @Autowired
    MemberEntityRepository memberEntityRepository;

    @Test
    @DisplayName("회원가입 테스트 입니다.")
    public void 회원가입() {
        //given -> 멤버가 주어짐
        MemberDto memberdto = new MemberDto("whipbaek@gmail.com", "tempPassword", "whipbaek");

        //when -> 가입하면
        Long count = memberService.join(memberdto);
        System.out.println("count = " + count);

        //then -> DB 접근하여 id 값이 같은지 확인해보자 (dto를 거치므로 객체는 다르게 저장됨)
        assertThat(memberdto.getEmail()).isEqualTo(memberEntityRepository.findOne(count).getEmail());

    }

    @Test
    @DisplayName("메일 중복 테스트 입니다.")
    public void 메일중복테스트(){
        //given
        MemberDto memberDto1 = new MemberDto("whipbaek@gmail.com", "1234", "whip1");
        MemberDto memberDto2 = new MemberDto("whipbaek@gmail.com", "1234", "whip2");
        memberService.join(memberDto1);

        //when, then
        assertThatThrownBy(() -> memberService.join(memberDto2))
                .isInstanceOf(DataIntegrityViolationException.class);
    }

    @Test
    public void 로그인테스트(){

        //given
        MemberDto memberDto = new MemberDto("whipbaek@gmail.com", "tempPassword", "whipbaek");
        MemberLoginDto memberLoginDtoSuccess = new MemberLoginDto("whipbaek@gmail.com", "tempPassword");
        MemberLoginDto memberLoginDtoFalse = new MemberLoginDto("whipbaek@gmail.com", "tempPassword2");

        //when
        memberService.join(memberDto);
        boolean loginStatus1 = memberService.login(memberLoginDtoSuccess);
        boolean loginStatus2 = memberService.login(memberLoginDtoFalse);

        //then
        assertThat(loginStatus1).isTrue();
        assertThat(loginStatus2).isFalse();

    }
}
