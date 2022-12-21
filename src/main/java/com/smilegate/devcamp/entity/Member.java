package com.smilegate.devcamp.entity;

import com.smilegate.devcamp.dto.MemberDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "member_number")
    private Long number;

    @NotNull
    @Column(length = 30, unique = true)
    @Email
    private String id;

    @NotNull
    @Column(length = 150)
    private String password;

    @NotNull
    @Column(length = 30)
    private String name;

    public Member(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public Member() {

    }

    public Member(MemberDto memberDto) {
        this.id = memberDto.getId();
        this.password = memberDto.getPassword();
        this.name = memberDto.getName();
    }

}
