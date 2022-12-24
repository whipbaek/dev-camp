package com.smilegate.devcamp.repository;

import com.smilegate.devcamp.dto.MemberDto;
import com.smilegate.devcamp.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberEntityRepository {
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(String email) {
        Member member = em.find(Member.class, email);
        return member;
    }

    public void editEntity(Member editMember) {
        Member member = em.find(Member.class, editMember.getEmail());
        member.setPassword(editMember.getPassword());
        member.setName(editMember.getName());
    }
}
