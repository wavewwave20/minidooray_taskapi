package com.nhnacademy.minidooraytaskapi.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CommentDto {
    private Long commentId;
    private String commentContent;
    private String commentCreationDate;
    private String userUUID;
    private Long taskId;

}
