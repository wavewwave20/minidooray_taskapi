package com.nhnacademy.minidooraytaskapi.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "task_tag")
public class TaskTag {

    @EmbeddedId
    private Pk pk;

    @Embeddable
    @EqualsAndHashCode
    @Getter
    @Setter
    public class Pk implements Serializable {
        @JoinColumn(name="task_id")
        @ManyToOne
        private Task task;

        @JoinColumn(name="tag_id")
        @ManyToOne
        private Tag tag;
    }
}
