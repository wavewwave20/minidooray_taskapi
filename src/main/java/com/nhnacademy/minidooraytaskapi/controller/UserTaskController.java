package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.UserTaskCreateDto;
import com.nhnacademy.minidooraytaskapi.service.UserTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class UserTaskController {
    private final UserTaskService userTaskService;

    public UserTaskController(UserTaskService userTaskService) {
        this.userTaskService = userTaskService;
    }

    @PostMapping("/tasks/{taskId}/users/{userUUID}")
    public void createUserTask(@PathVariable Long taskId, @PathVariable String userUUID) {
        userTaskService.createUserTask(taskId, userUUID);
    }

    @GetMapping("/users/{userUUID}/tasks")
    public ResponseEntity<List<UserTaskCreateDto>> getUserTaskByUserId(@PathVariable String userUUID) {
        List<UserTaskCreateDto> userTaskCreateDtos = userTaskService.getUserTaskByUserId(userUUID);
        return ResponseEntity.ok(userTaskCreateDtos);
    }

    @GetMapping("/tasks/{taskId}/users")
    public ResponseEntity<List<UserTaskCreateDto>> getUserTaskByTaskId(@PathVariable Long taskId) {
        List<UserTaskCreateDto> userTaskCreateDtos = userTaskService.getUserTaskByTaskId(taskId);
        return ResponseEntity.ok(userTaskCreateDtos);
    }

    @DeleteMapping("/tasks/{taskId}/users/{userUUID}")
    public void deleteUserTask(@PathVariable Long taskId, @PathVariable String userUUID) {
        userTaskService.deleteUserTask(taskId, userUUID);
    }
}
