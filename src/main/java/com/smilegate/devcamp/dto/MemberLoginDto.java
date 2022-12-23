package com.smilegate.devcamp.dto;

import com.smilegate.devcamp.entity.Member;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MemberLoginDto {

    @NotBlank(message = "이메일은 필수 입력 사항입니다.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력 사항입니다.")
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
