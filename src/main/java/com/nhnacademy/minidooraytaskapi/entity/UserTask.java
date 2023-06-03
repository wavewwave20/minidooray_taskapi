package com.nhnacademy.minidooraytaskapi.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "user_task")
public class UserTask {

    @EmbeddedId
    private Pk pk;

    @Embeddable
    public class Pk implements Serializable {
        @ManyToOne
        @JoinColumn
        private User user;

        @ManyToOne
        @JoinColumn
        private Task task;
    }

}
