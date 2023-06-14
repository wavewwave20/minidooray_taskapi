package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.CommentDto;
import com.nhnacademy.minidooraytaskapi.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment/list")
    public ResponseEntity<List<CommentDto>> getAllComment() {
        List<CommentDto> commentDtoList = commentService.getAllComment();
        return ResponseEntity.ok(commentDtoList);
    }

    @GetMapping("/comment?comment={commentId}")
    public CommentDto getCommentById(@RequestParam Long commentId) {
        return commentService.getCommentById(commentId);
    }

    @GetMapping("/comment/list?task={taskId}")
    public ResponseEntity<List<CommentDto>> getCommentByTaskId(@RequestParam Long taskId) {
        List<CommentDto> commentDtoList = commentService.getCommentByTaskId(taskId);
        return ResponseEntity.ok(commentDtoList);
    }

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
