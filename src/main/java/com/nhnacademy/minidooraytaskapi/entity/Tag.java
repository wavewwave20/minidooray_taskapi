package com.nhnacademy.minidooraytaskapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @Column(name="tag_id")
    private Long tagId;

    @Column(name="tag_name")
    private String tagName;

    @JoinColumn(name="project_id")
    @ManyToOne
    private Project project;
}
