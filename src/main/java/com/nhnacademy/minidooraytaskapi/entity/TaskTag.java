package com.nhnacademy.minidooraytaskapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "task_tag")
public class TaskTag {

    @EmbeddedId
    private Pk pk;

    @Embeddable
    public class Pk implements Serializable {
        @JoinColumn(name="task_id")
        @ManyToOne
        private Task task;

        @JoinColumn(name="tag_id")
        @ManyToOne
        private Tag tag;
    }
}
