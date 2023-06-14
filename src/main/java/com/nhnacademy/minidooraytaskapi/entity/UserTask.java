package com.nhnacademy.minidooraytaskapi.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "user_task")
public class UserTask {

    @EmbeddedId
    private Pk pk;

    @Embeddable
    @EqualsAndHashCode
    @Getter
    @Setter
    public static class Pk implements Serializable {
        @ManyToOne
        @JoinColumn
        private User user;

        @ManyToOne
        @JoinColumn
        private Task task;
    }

}
