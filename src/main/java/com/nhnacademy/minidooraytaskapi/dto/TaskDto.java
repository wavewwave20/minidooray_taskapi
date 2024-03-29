package com.nhnacademy.minidooraytaskapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDto {

    private Long taskId;

    private String taskName;

    private String taskContent;

    private LocalDateTime taskCreationDate;

    private LocalDateTime taskEndDate;

    private String userUUID;

    private Long projectId;
}
