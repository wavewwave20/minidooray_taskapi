package com.nhnacademy.minidooraytaskapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {

    public enum ProjectStatusEnum {
        ACTIVE, INACTIVE, CLOSED;
    }

    @Id
    @Column(name="project_id")
    private Long projectId;

    @Column(name="project_name")
    private String projectName;

    @Column(name="project_description")
    private String projectDescription;

    @Column(name="project_status")
    private ProjectStatusEnum projectStatus;

    @JoinColumn(name="user_uuid")
    @ManyToOne
    private User user;
}
