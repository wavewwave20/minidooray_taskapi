package com.nhnacademy.minidooraytaskapi.dto;

import com.nhnacademy.minidooraytaskapi.entity.Milestone;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class MilestoneDto {
    private Long milestoneId;
    private String milestoneName;
    private LocalDateTime milestoneStartDate;
    private LocalDateTime milestoneEndDate;
    private Milestone.MilestoneStatusEnum milestoneStatus;
    private Long projectId;


}
