package com.nhnacademy.minidooraytaskapi.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name="user_uuid")
    private String userUUID;
    @Column(name="user_id")
    private String userId;

    @Column(name="user_nickname")
    private String userNickname;

    @Column(name="user_email")
    private String userEmail;


    public User(String userId, String userNickname) {
        this.userId = userId;
        this.userNickname = userNickname;
    }

    public User() {

    }
}
