package com.nhnacademy.minidooraytaskapi.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
