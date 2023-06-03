package com.nhnacademy.minidooraytaskapi.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="milestone_id")
    private Long milestoneId;

    @Column(name="milestone_name")
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
