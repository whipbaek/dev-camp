package com.smilegate.devcamp.service;

import com.smilegate.devcamp.dto.MemberDto;
import com.smilegate.devcamp.dto.MemberLoginDto;
import com.smilegate.devcamp.entity.Member;
import com.smilegate.devcamp.repository.MemberEntityRepository;
import com.smilegate.devcamp.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberEntityRepository memberEntityRepository;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String join(MemberDto memberdto) {
            memberdto.setPassword(encode(memberdto.getPassword()));
            Member member = new Member(memberdto); // dto 변환은 Service side 에서 진행
            memberEntityRepository.save(member);
            return member.getEmail();
    }

    private String encode(String password){
        return passwordEncoder.encode(password);
    }


    public MemberDto findOne(String email) {
        return new MemberDto(memberEntityRepository.findOne(email));
    }

    public boolean validateDuplicatedEmail(MemberDto memberDto) {
        try {
            if (memberRepository.existsByEmail(memberDto.getEmail())) {
                throw new DataIntegrityViolationException("이미 존재하는 메일입니다.");
            }
            return false;
        }
        catch (DataIntegrityViolationException e){
            log.info("{}",e.getMessage());
            return true;
        }
    }

    public Member login(MemberLoginDto memberLoginDto) {
        Member member = memberRepository.findByEmail(memberLoginDto.getEmail());
        if(member == null) return null;
        if(passwordEncoder.matches(memberLoginDto.getPassword(), member.getPassword())){
            return member;
        }
        return null;
    }

    public void editMemberInfo(MemberDto memberDto) {
        memberDto.setPassword(encode(memberDto.getPassword()));
        Member member = new Member(memberDto); // dto 변환은 Service side 에서 진행
        memberEntityRepository.editEntity(member);
    }
}
