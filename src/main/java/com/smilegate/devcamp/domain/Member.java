package com.smilegate.devcamp.domain;

import lombok.Getter;
import lombok.Setter;

//import javax.persistence.*;

//@Entity
//@Table(name = "member")
@Getter
@Setter
public class Member {
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "member_id")
    private Long id;

    private String name;

    private String password;


}
