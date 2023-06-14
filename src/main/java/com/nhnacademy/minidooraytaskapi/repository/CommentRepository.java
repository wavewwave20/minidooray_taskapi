package com.nhnacademy.minidooraytaskapi.repository;

import com.nhnacademy.minidooraytaskapi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByTaskTaskId(Long taskId);
}
