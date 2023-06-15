package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.TagDto;
import com.nhnacademy.minidooraytaskapi.dto.TaskDto;
import com.nhnacademy.minidooraytaskapi.service.TaskTagService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class TaskTagController {

    private final TaskTagService taskTagService;

    public TaskTagController(TaskTagService taskTagService) {
        this.taskTagService = taskTagService;
    }

    @PostMapping("/task-tag?task={taskId}&tag={tagId}")
    public void createTaskTag(@RequestParam Long taskId, @RequestParam Long tagId) {
        taskTagService.createTaskTag(taskId, tagId);
    }

    @GetMapping("/task-tag/list?task={taskId}")
    public ResponseEntity<List<TagDto>> getTagsByTask(@RequestParam Long taskId) {
        List<TagDto> tagDtos = taskTagService.getTagsByTask(taskId);
        return ResponseEntity.ok(tagDtos);
    }

    @GetMapping("/task-tag/list?tag={tagId}")
    public ResponseEntity<List<TaskDto>> getTasksByTag(@RequestParam Long tagId) {
        List<TaskDto> taskDtos = taskTagService.getTasksByTag(tagId);
        return ResponseEntity.ok(taskDtos);
    }

    @DeleteMapping("/task-tag?task={taskId}&tag={tagId}")
    public void deleteTaskTag(@RequestParam Long taskId, @RequestParam Long tagId) {
        taskTagService.deleteTaskTag(taskId, tagId);
    }


}
