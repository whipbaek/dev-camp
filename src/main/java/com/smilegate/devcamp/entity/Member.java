package com.smilegate.devcamp.entity;

import com.smilegate.devcamp.dto.MemberDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_number")
    private Long number;

    @Column(length = 30, unique = true)
    @Email
    private String email;

    @Column(length = 150)
    private String password;

    @Column(length = 30)
    private String name;

    public Member(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public Member() {

    }

    public Member(MemberDto memberDto) {
        this.email = memberDto.getEmail();
        this.password = memberDto.getPassword();
        this.name = memberDto.getName();
    }

}
