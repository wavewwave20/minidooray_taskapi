package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.CommentDto;
import com.nhnacademy.minidooraytaskapi.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/taskapi/comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/")
    public List<CommentDto> getAllComment() {
        return commentService.getAllComment();
    }

    @GetMapping("/{commentId}")
    public CommentDto getCommentById(@PathVariable Long commentId) {
        return commentService.getCommentById(commentId);
    }

    @PostMapping("/")
    public void createComment(@RequestBody CommentDto commentDto) {
        commentService.createComment(commentDto);
    }

    @PutMapping("/{commentId}")
    public void updateCommentById(@PathVariable Long commentId, @RequestBody CommentDto commentDto) {
        commentService.updateCommentById(commentId, commentDto);
    }

    @DeleteMapping("/{commentId}")
    public void deleteCommentById(@PathVariable Long commentId) {
        commentService.deleteCommentById(commentId);
    }
}
