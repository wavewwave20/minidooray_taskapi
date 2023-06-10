package com.nhnacademy.minidooraytaskapi.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserRegisterDto {
    private String userUUID;
    private String userId;
    private String userPassword;
    private String userNickname;
    private String userEmail;
}
