package com.smilegate.devcamp.service;

import com.smilegate.devcamp.domain.Member;
import com.smilegate.devcamp.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
//        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getCount();
    }

    public Member findOne(Long memberCount) {
        return memberRepository.findOne(memberCount);
    }

//    private void validateDuplicateMember(Member member) {
//        List<Member> findMembers = memberRepository.findByName(member.getName());
//        if (!findMembers.isEmpty()) {
//            throw new IllegalStateException("이미 존재하는 회원입니다!");
//        }
//    }

}