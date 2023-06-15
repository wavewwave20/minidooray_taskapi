package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.TagDto;
import com.nhnacademy.minidooraytaskapi.dto.TaskDto;
import com.nhnacademy.minidooraytaskapi.service.TaskTagService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/task")
public class TaskTagController {

    private final TaskTagService taskTagService;

    public TaskTagController(TaskTagService taskTagService) {
        this.taskTagService = taskTagService;
    }

    @PostMapping("/tasks/{taskId}/tags/{tagId}")
    public ResponseEntity<?> createTaskTag(@PathVariable Long taskId, @PathVariable Long tagId) {
        taskTagService.createTaskTag(taskId, tagId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/tasks/{taskId}/tags")
    public ResponseEntity<List<TagDto>> getTagsByTask(@PathVariable Long taskId) {
        List<TagDto> tagDtos = taskTagService.getTagsByTask(taskId);
        return ResponseEntity.ok(tagDtos);
    }

    @GetMapping("/tags/{tagId}/tasks")
    public ResponseEntity<List<TaskDto>> getTasksByTag(@PathVariable Long tagId) {
        List<TaskDto> taskDtos = taskTagService.getTasksByTag(tagId);
        return ResponseEntity.ok(taskDtos);
    }

    @DeleteMapping("/tasks/{taskId}/tags/{tagId}")
    public ResponseEntity<?> deleteTaskTag(@PathVariable Long taskId, @PathVariable Long tagId) {
        taskTagService.deleteTaskTag(taskId, tagId);
        return ResponseEntity.ok().build();
    }
}
