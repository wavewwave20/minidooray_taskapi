package com.nhnacademy.minidooraytaskapi.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "task")
public class Task {
    @Id
    @Column(name="task_id")
    private Long taskId;
    @Column(name="task_name")
    private String taskName;

    @Column(name="task_content")
    private String taskContent;

    @Column(name="task_creationdate")
    private LocalDateTime taskCreationDate;

    @Column(name="task_enddate")
    private LocalDateTime taskEndDate;

    @ManyToOne
    @JoinColumn(name="milestone_id")
    private Milestone milestone;

    @ManyToOne
    @JoinColumn(name="user_uuid")
    private User user;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;
}
