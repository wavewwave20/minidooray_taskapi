package com.nhnacademy.minidooraytaskapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {
    private String userId;

    private String userNickname;

    private String userEmail;
}
