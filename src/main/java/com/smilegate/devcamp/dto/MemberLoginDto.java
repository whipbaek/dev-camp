package com.smilegate.devcamp.dto;

import com.smilegate.devcamp.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberLoginDto {
    private String email;
    private String password;

    public MemberLoginDto() {
    }

    public MemberLoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public MemberLoginDto (Member member) {
        this.email = member.getEmail();
        this.password = member.getPassword();
    }
}
