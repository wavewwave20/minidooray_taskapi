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
@Table(name = "comment")
public class Comment {

        @Id
        @Column(name="comment_id")
        private Long commentId;

        @Column(name="comment_content")
        private String commentContent;

        @Column(name="comment_creationdate")
        private String commentCreationDate;

}
