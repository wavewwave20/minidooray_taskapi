package com.nhnacademy.minidooraytaskapi.dto;

import com.nhnacademy.minidooraytaskapi.entity.ProjectStatusEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProjectDto {
    private Long ProjectId;
    private String ProjectName;
    private String ProjectDescription;
    private ProjectStatusEnum ProjectStatus;
    private String UserUUID;
}
