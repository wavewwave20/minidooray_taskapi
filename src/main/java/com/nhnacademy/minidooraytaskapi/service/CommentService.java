package com.nhnacademy.minidooraytaskapi.service;

import com.nhnacademy.minidooraytaskapi.dto.CommentDto;
import com.nhnacademy.minidooraytaskapi.entity.Comment;
import com.nhnacademy.minidooraytaskapi.repository.CommentRepository;
import com.nhnacademy.minidooraytaskapi.repository.TaskRepository;
import com.nhnacademy.minidooraytaskapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Transactional(readOnly = true)
    public List<CommentDto> getAllComment() {
        List<Comment> commentList = commentRepository.findAll();
        List<CommentDto> commentDtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            commentDtoList.add(toDto(comment));
        }
        return commentDtoList;
    }

    @Transactional(readOnly = true)
    public CommentDto getCommentById(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        return toDto(comment);
    }

    @Transactional
    public void createComment(CommentDto commentDto) {
        commentRepository.save(toEntity(commentDto));
    }

    @Transactional
    public void updateCommentById(Long commentId, CommentDto commentDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        comment.setCommentContent(commentDto.getCommentContent());
        commentRepository.save(comment);
    }

    @Transactional
    public void deleteCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    private CommentDto toDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setCommentId(comment.getCommentId());
        commentDto.setCommentContent(comment.getCommentContent());
        commentDto.setCommentCreationDate(comment.getCommentCreationDate());
        commentDto.setUserUUID(comment.getUser().getUserUUID());
        commentDto.setTaskId(comment.getTask().getTaskId());
        //#TODO: commentDto.setTaskId(comment.getTask().getTaskId()); 처럼 처리해도 가능?????
        return commentDto;
    }

    //#TODO: toEntity() 메소드를 이런식으로 써도 되나..?
    private Comment toEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setCommentId(commentDto.getCommentId());
        comment.setCommentContent(commentDto.getCommentContent());
        comment.setCommentCreationDate(commentDto.getCommentCreationDate());
        comment.setUser(userRepository.findByUserUUID(commentDto.getUserUUID()));
        comment.setTask(taskRepository.findById(commentDto.getTaskId()).orElseThrow());
        return comment;
    }
}
