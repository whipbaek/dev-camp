package com.smilegate.devcamp.dto;

import com.smilegate.devcamp.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 유저에게 정보 입력받는 DTO (View Side)
 */

@Getter
@Setter
public class MemberDto {
    private String id;
    private String password;
    private String name;

    public MemberDto() {
    }

    public MemberDto(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public MemberDto (Member member) {
        this.id = member.getId();
        this.password = member.getPassword();
        this.name = member.getName();
    }

    @Override
    public String toString(){
        return "id : " + this.id + " , password : " + this.password + " , name : " + this.name;
    }
}
