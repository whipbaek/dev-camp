package com.smilegate.devcamp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDto {
    private String codeNumber;

    public EmailDto(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public EmailDto() {
    }
}
