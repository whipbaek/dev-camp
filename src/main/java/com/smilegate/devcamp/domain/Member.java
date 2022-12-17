package com.smilegate.devcamp.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "member_count")
    private Long count;

    @NotNull
    @Column(length = 30, unique = true)
    private String id;

    @NotNull
    @Column(length = 30)
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
}
