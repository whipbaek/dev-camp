package com.smilegate.devcamp.dto;

import com.smilegate.devcamp.entity.Member;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * 유저에게 정보 입력받는 DTO (View Side)
 */

@Getter
@Setter
public class MemberDto {

    @NotBlank(message = "이메일은 필수 입력 사항입니다.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력 사항입니다.")
    private String password;

    @NotBlank(message = "이름은 필수 입력 사항입니다.")
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

    public MemberDto(MemberDto memberDto) {
        this.email = memberDto.getEmail();
        this.password = memberDto.getPassword();
        this.name = memberDto.getName();
    }

    @Override
    public String toString(){
        return "email : " + this.email + " , password : " + this.password + " , name : " + this.name;
    }
}
