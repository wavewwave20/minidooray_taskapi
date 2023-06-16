package com.nhnacademy.minidooraytaskapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTaskCreateDto {
    private String userUUID;

    private Long taskId;
}
