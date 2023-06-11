package com.nhnacademy.minidooraytaskapi.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@RequiredArgsConstructor
public class TagDto {
    private Long tagId;
    private String tagName;
    private Long projectId;
}
