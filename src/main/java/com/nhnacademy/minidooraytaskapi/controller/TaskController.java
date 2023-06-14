package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.TaskCreateDto;
import com.nhnacademy.minidooraytaskapi.dto.TaskDto;
import com.nhnacademy.minidooraytaskapi.dto.UserGetDto;
import com.nhnacademy.minidooraytaskapi.entity.Task;
import com.nhnacademy.minidooraytaskapi.entity.User;
import com.nhnacademy.minidooraytaskapi.service.TaskService;
import com.nhnacademy.minidooraytaskapi.service.UserService;
import com.nhnacademy.minidooraytaskapi.service.UserTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;
    private final UserTaskService userTaskService;
    private final UserService userService;

    @PostMapping("/task")
    public void createTask(TaskCreateDto taskCreateDto) {
        taskService.createTask(taskCreateDto);
    }

    @GetMapping("/task")
    public ResponseEntity<TaskDto> getTaskById(@RequestParam Long taskId) {
        TaskDto taskDto = taskService.getTaskById(taskId);
        return ResponseEntity.ok(taskDto);
    }

    @GetMapping("/task/list?project={projectId}")
    public ResponseEntity<List<TaskDto>> getTaskByProjectId(@RequestParam Long projectId) {
        List<TaskDto> taskDtos = taskService.getTaskByProjectId(projectId);
        return ResponseEntity.ok(taskDtos);
    }

    @GetMapping("/task/list?user={userUUID}")
    public ResponseEntity<List<TaskDto>> getTaskByAdminUserUUID(@RequestParam String userUUID) {
        List<TaskDto> taskDtos = taskService.getTaskByAdminUserUUID(userUUID);
        return ResponseEntity.ok(taskDtos);
    }

    @PutMapping("/task?task={taskId}")
    public void updateTaskById(@RequestParam Long taskId, @RequestBody TaskCreateDto taskCreateDto) {
        taskService.updateTaskById(taskId, taskCreateDto);
    }

    @DeleteMapping("/task?task={taskId}")
    public void deleteTaskById(@RequestParam Long taskId) {
        //      taskService.deleteTaskById(taskId);
    }
}