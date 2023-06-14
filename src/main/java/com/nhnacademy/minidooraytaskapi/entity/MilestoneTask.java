package com.nhnacademy.minidooraytaskapi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "milestone_task")
public class MilestoneTask {
    @EmbeddedId
    private Pk pk;

    @Getter
    @Setter
    @Embeddable
    @EqualsAndHashCode
    public static class Pk implements Serializable {
        @JoinColumn(name="milestone_id")
        @ManyToOne
        private Milestone milestone;

        @JoinColumn(name="task_id")
        @ManyToOne
        private Task task;
    }
}
