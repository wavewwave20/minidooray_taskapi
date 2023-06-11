package com.nhnacademy.minidooraytaskapi.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class TaskCreateDto {
    private String taskName;

    private String taskContent;

    private LocalDateTime taskCreationDate;

    private LocalDateTime taskEndDate;

    private String userUUID;

    private Long projectId;
}
