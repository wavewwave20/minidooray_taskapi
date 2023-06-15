package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.CommentDto;
import com.nhnacademy.minidooraytaskapi.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class CommentController {

    private final CommentService commentService;

//    @GetMapping("/comments")
//    public ResponseEntity<List<CommentDto>> getAllComment() {
//        List<CommentDto> commentDtoList = commentService.getAllComment();
//        return ResponseEntity.ok(commentDtoList);
//    }

    @GetMapping("/comments/{commentId}")
    public CommentDto getCommentById(@PathVariable Long commentId) {
        return commentService.getCommentById(commentId);
    }

    @GetMapping("/comments/tasks/{taskId}")
    public ResponseEntity<List<CommentDto>> getCommentByTaskId(@PathVariable Long taskId) {
        List<CommentDto> commentDtoList = commentService.getCommentByTaskId(taskId);
        return ResponseEntity.ok(commentDtoList);
    }

    @PostMapping("/comments")
    public void createComment(@RequestBody CommentDto commentDto) {
        commentService.createComment(commentDto);
    }

    @PutMapping("/comments/{commentId}")
    public void updateCommentById(@PathVariable Long commentId, @RequestBody CommentDto commentDto) {
        commentService.updateCommentById(commentId, commentDto);
    }

    @DeleteMapping("/comments/{commentId}")
    public void deleteCommentById(@PathVariable Long commentId) {
        commentService.deleteCommentById(commentId);
    }
}
