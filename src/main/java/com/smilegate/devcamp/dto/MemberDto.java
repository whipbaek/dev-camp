package com.smilegate.devcamp.dto;

import com.smilegate.devcamp.entity.Member;
import lombok.Getter;
import lombok.Setter;

/**
 * 유저에게 정보 입력받는 DTO (View Side)
 */

@Getter
@Setter
public class MemberDto {
    private String email;
    private String password;
    private String name;

    public MemberDto() {
    }

    public MemberDto(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public MemberDto (Member member) {
        this.email = member.getEmail();
        this.password = member.getPassword();
        this.name = member.getName();
    }

    @Override
    public String toString(){
        return "email : " + this.email + " , password : " + this.password + " , name : " + this.name;
    }
}
