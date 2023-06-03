package com.nhnacademy.minidooraytaskapi.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="comment_id")
        private Long commentId;

        @Column(name="comment_content")
        private String commentContent;

        @Column(name="comment_creationdate")
        private String commentCreationDate;

        @JoinColumn(name="user_uuid")
        @ManyToOne
        private User user;

        @JoinColumn(name="task_id")
        @ManyToOne
        private Task task;

}
