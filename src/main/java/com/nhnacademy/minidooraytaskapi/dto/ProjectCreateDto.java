package com.nhnacademy.minidooraytaskapi.dto;

import com.nhnacademy.minidooraytaskapi.entity.ProjectStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectCreateDto {

    private String projectName;

    private String projectDescription;

    private ProjectStatusEnum projectStatus;

    private String userUUID;
}
