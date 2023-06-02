package com.nhnacademy.minidooraytaskapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

}
