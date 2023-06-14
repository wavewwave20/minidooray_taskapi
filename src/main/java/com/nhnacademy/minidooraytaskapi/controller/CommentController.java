package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.CommentDto;
import com.nhnacademy.minidooraytaskapi.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment")
    public List<CommentDto> getAllComment() {
        return commentService.getAllComment();
    }

    @GetMapping("/comment?comment={commentId}")
    public CommentDto getCommentById(@RequestParam Long commentId) {
        return commentService.getCommentById(commentId);
    }

    //TODO: taskid로 comment 가져오기

    @PostMapping("/comment")
    public void createComment(@RequestBody CommentDto commentDto) {
        commentService.createComment(commentDto);
    }

    @PutMapping("/comment?comment={commentId}")
    public void updateCommentById(@RequestParam Long commentId, @RequestBody CommentDto commentDto) {
        commentService.updateCommentById(commentId, commentDto);
    }

    @DeleteMapping("/comment?comment={commentId}")
    public void deleteCommentById(@RequestParam Long commentId) {
        commentService.deleteCommentById(commentId);
    }
}
