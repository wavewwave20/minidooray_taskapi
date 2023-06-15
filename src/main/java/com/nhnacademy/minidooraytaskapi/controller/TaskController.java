package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.TaskCreateDto;
import com.nhnacademy.minidooraytaskapi.dto.TaskDto;
import com.nhnacademy.minidooraytaskapi.service.TaskService;
import com.nhnacademy.minidooraytaskapi.service.UserService;
import com.nhnacademy.minidooraytaskapi.service.UserTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;
    private final UserTaskService userTaskService;
    private final UserService userService;

    @PostMapping("/tasks")
    public void createTask(@RequestBody TaskCreateDto taskCreateDto) {
        taskService.createTask(taskCreateDto);
    }

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long taskId) {
        TaskDto taskDto = taskService.getTaskById(taskId);
        return ResponseEntity.ok(taskDto);
    }

    @GetMapping("/tasks/projects/{projectId}")
    public ResponseEntity<List<TaskDto>> getTaskByProjectId(@PathVariable Long projectId) {
        List<TaskDto> taskDtos = taskService.getTaskByProjectId(projectId);
        return ResponseEntity.ok(taskDtos);
    }

    @GetMapping("/tasks/users/{userUUID}/admin")
    public ResponseEntity<List<TaskDto>> getTaskByAdminUserUUID(@PathVariable String userUUID) {
        List<TaskDto> taskDtos = taskService.getTaskByAdminUserUUID(userUUID);
        return ResponseEntity.ok(taskDtos);
    }

    @PutMapping("/tasks/{taskId}")
    public void updateTaskById(@PathVariable Long taskId, @RequestBody TaskCreateDto taskCreateDto) {
        taskService.updateTaskById(taskId, taskCreateDto);
    }

    @DeleteMapping("/tasks/{taskId}")
    public void deleteTaskById(@PathVariable Long taskId) {
        taskService.deleteTaskById(taskId);
    }
}