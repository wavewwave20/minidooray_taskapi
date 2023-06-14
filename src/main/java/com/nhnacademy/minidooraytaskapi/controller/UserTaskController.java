package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.UserTaskCreateDto;
import com.nhnacademy.minidooraytaskapi.service.UserTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserTaskController {
    private final UserTaskService userTaskService;

    public UserTaskController(UserTaskService userTaskService) {
        this.userTaskService = userTaskService;
    }

    @PostMapping("/user-task")
    public void createUserTask(@RequestBody UserTaskCreateDto userTaskCreateDto) {
        userTaskService.createUserTask(userTaskCreateDto);
    }

    @GetMapping("/user-task/list?userUUID={userUUID}")
    public ResponseEntity<List<UserTaskCreateDto>> getUserTaskByUserId(@RequestParam String userUUID) {
        List<UserTaskCreateDto> userTaskCreateDtos = userTaskService.getUserTaskByUserId(userUUID);
        return ResponseEntity.ok(userTaskCreateDtos);
    }

    @GetMapping("/user-task/list?taskId={taskId}")
    public ResponseEntity<List<UserTaskCreateDto>> getUserTaskByTaskId(@RequestParam Long userId) {
        List<UserTaskCreateDto> userTaskCreateDtos = userTaskService.getUserTaskByTaskId(userId);
        return ResponseEntity.ok(userTaskCreateDtos);
    }
}
