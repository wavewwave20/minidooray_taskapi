package com.nhnacademy.minidooraytaskapi.dto;

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
    private int ProjectStatus;
    //#TODO ProjectStatus ENUM으로 던지는 대신 Service에서 int 로 받아서 변경처리?

}
