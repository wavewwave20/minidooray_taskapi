package com.nhnacademy.minidooraytaskapi.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "milestone")
public class Milestone {
    public enum MilestoneStatusEnum {
        ACTIVE, INACTIVE, COMPLETED;
    }

    @Id
    @Column(name="milestone_id")
    private Long milestoneId;

    @Column(name="project_id")
    private String milestoneName;

    @Column(name="milestone_startdate")
    private LocalDateTime milestoneStartDate;

    @Column(name="milestone_enddate")
    private LocalDateTime milestoneEndDate;

    @Column(name="milestone_status")
    private MilestoneStatusEnum milestoneStatus;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

}
