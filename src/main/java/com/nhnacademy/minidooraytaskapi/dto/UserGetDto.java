package com.nhnacademy.minidooraytaskapi.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserGetDto {
    private String userUUID;
    private String userId;
    private String userNickName;
    private String userEmail;
}
