package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.entity.Comment;
import com.nhnacademy.minidooraytaskapi.entity.Project;
import com.nhnacademy.minidooraytaskapi.entity.Task;
import com.nhnacademy.minidooraytaskapi.service.TaskService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/taskapi/tasks")
public class TaskController {

    private final TaskService taskService;

    //###################Project Api###################
    @GetMapping("/api/tasks/project")
    public List<Project> getAllProject() {
        return taskService.getAllProject();
    }

    @GetMapping("/api/tasks/project/{projectId}")
    public Project getProjectById(@PathVariable Long projectId) {
        return taskService.getProjectById(projectId);
    }

    @PostMapping("/api/tasks/project")
    public Project createProject(@RequestBody Project project) {
        return taskService.createProject(project);
    }

    @PutMapping("/api/tasks/project/{projectId}")
    public Project updateProjectById(@PathVariable Long projectId,@RequestBody Project project) {
        return taskService.updateProjectById(projectId, project);
    }

    @DeleteMapping("/api/tasks/project/{projectId}")
    public void deleteProjectById(@PathVariable Long projectId) {
        taskService.deleteProjectById(projectId);
    }

    //###################Task Api###################

    @GetMapping("/api/tasks")
    public List<Task> getAllTask() {
        return taskService.getAllTask();
    }

    @GetMapping("/api/tasks/{taskId}")
    public Task getTaskById(Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PostMapping("/api/tasks")
    public Task createTask(Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/api/tasks/{taskId}")
    public Task updateTaskById(Long taskId, Task task) {
        return taskService.updateTaskById(taskId, task);
    }

    @DeleteMapping("/api/tasks/{taskId}")
    public void deleteTaskById(Long taskId) {
        taskService.deleteTaskById(taskId);
    }


    //###################Comment Api###################

    @GetMapping("/api/tasks/comment")
    public List<Comment> getAllComment() {
        return taskService.getAllComment();
    }

    @GetMapping("/api/tasks/comment/{commentId}")
    public Comment getCommentById(Long commentId) {
        return taskService.getCommentById(commentId);
    }

    @PostMapping("/api/tasks/comment")
    public Comment createComment(Comment comment) {
        return taskService.createComment(comment);
    }

    @PutMapping("/api/tasks/comment/{commentId}")
    public Comment updateCommentById(Long commentId, Comment comment) {
        return taskService.updateCommentById(commentId, comment);
    }

    @DeleteMapping("/api/tasks/comment/{commentId}")
    public void deleteCommentById(Long commentId) {
        taskService.deleteCommentById(commentId);
    }


}
