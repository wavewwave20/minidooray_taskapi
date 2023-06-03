package com.nhnacademy.minidooraytaskapi.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "user_project")
public class UserProject {

    @EmbeddedId
    private Pk pk;

    @Embeddable
    public class Pk implements Serializable {
        @JoinColumn(name="user_uuid")
        @ManyToOne
        private User user;

        @JoinColumn(name="project_id")
        @ManyToOne
        private Project project;
    }
}
