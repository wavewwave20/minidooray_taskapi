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
@Table(name = "user")
public class User {

    @Id
    @Column(name="user_uuid")
    private String userUUID;
    @Column(name="user_id")
    private String userId;
    @Column(name="user_pasword")
    private String userPassword;
    @Column(name="user_email")
    private String userEmail;
    @Column(name="user_nickname")
    private String userNickname;

}
