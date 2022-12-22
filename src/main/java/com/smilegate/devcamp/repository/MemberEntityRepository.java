package com.smilegate.devcamp.repository;

import com.smilegate.devcamp.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberEntityRepository {
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long count) {
        Member member = em.find(Member.class, count);
        return member;
    }
}
