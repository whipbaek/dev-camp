package com.smilegate.devcamp.service;

import com.smilegate.devcamp.dto.MemberDto;
import com.smilegate.devcamp.entity.Member;
import com.smilegate.devcamp.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long join(MemberDto memberdto) {
//        validateDuplicateMember(member);
        Member member = new Member(memberdto); // dto 변환은 Service side 에서 진행
        memberRepository.save(member);
        return member.getNumber();
    }

    public MemberDto findOne(Long memberCount) {
        return new MemberDto(memberRepository.findOne(memberCount));
    }

//    private void validateDuplicateMember(Member member) {
//        List<Member> findMembers = memberRepository.findByName(member.getName());
//        if (!findMembers.isEmpty()) {
//            throw new IllegalStateException("이미 존재하는 회원입니다!");
//        }
//    }

}
