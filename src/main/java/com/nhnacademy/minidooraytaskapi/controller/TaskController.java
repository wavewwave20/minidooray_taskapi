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


@RestController
@RequiredArgsConstructor
@RequestMapping("/taskapi/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserTaskService userTaskService;
    private final UserService userService;

    //#TODO:생성시에 UserTask 생성하도록 변경했습니다
    @PostMapping("/create")
    public void createTask(TaskCreateDto taskCreateDto) {
        taskService.createTask(taskCreateDto);
        UserGetDto user = userService.getUserByUUId(taskCreateDto.getUserUUID());
        TaskDto task = taskService.getTaskByName(taskCreateDto.getTaskName());
        User userEntity = toUserEntity(user);
        Task taskEntity = toTaskEntity(task);
        userTaskService.createUserTask(userEntity, taskEntity);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long taskId) {
        TaskDto taskDto = taskService.getTaskById(taskId);
        return ResponseEntity.ok(taskDto);
    }

    @PutMapping("/{taskId}")
    public void updateTaskById(@PathVariable Long taskId, @RequestBody TaskCreateDto taskCreateDto) {
        taskService.updateTaskById(taskId, taskCreateDto);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTaskById(@PathVariable Long taskId) {
        //      taskService.deleteTaskById(taskId);
    }

    //#TODO:UserTask를 통해 User UUID로 Task를 조회하도록 추가
    @GetMapping("/user/{userUUID}")
    public TaskDto getTaskByUserUUID(@PathVariable String userUUID) {
        return taskService.getTaskByUserUUID(userUUID);
    }

    //#TODO:UserTask를 통해 Task Name으로 User를 조회하도록 추가
    @GetMapping("/task/{taskName}")
    public UserGetDto getUserByTaskName(@PathVariable String taskName) {
        return userTaskService.getUserByTaskName(taskName);
    }


    public User toUserEntity(UserGetDto userGetDto) {
        User user = new User();
        user.setUserUUID(userGetDto.getUserUUID());
        user.setUserNickname(userGetDto.getUserNickName());
        user.setUserId(userGetDto.getUserId());
        user.setUserEmail(userGetDto.getUserEmail());
        return user;
    }

    public Task toTaskEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setTaskId(taskDto.getTaskId());
        task.setTaskName(taskDto.getTaskName());
        task.setTaskContent(taskDto.getTaskContent());
        task.setTaskCreationDate(taskDto.getTaskCreationDate());
        task.setTaskEndDate(taskDto.getTaskEndDate());
        task.setUser(toUserEntity(userService.getUserByUUId(taskDto.getUserUUID())));
        task.setProject(taskService.getProjectById(taskDto.getProjectId()));
        return task;
    }

}


//    //###################Project Api###################
//    @GetMapping("/api/tasks/project")
//    public List<Project> getAllProject() {
//        return taskService.getAllProject();
//    }
//
//    @GetMapping("/api/tasks/project/{projectId}")
//    public Project getProjectById(@PathVariable Long projectId) {
//        return taskService.getProjectById(projectId);
//    }
//
//    @PostMapping("/api/tasks/project")
//    public Project createProject(@RequestBody Project project) {
//        return taskService.createProject(project);
//    }
//
//    @PutMapping("/api/tasks/project/{projectId}")
//    public Project updateProjectById(@PathVariable Long projectId,@RequestBody Project project) {
//        return taskService.updateProjectById(projectId, project);
//    }
//
//    @DeleteMapping("/api/tasks/project/{projectId}")
//    public void deleteProjectById(@PathVariable Long projectId) {
//        taskService.deleteProjectById(projectId);
//    }
//
//    //###################Task Api###################
//
//    @GetMapping("/api/tasks")
//    public List<Task> getAllTask() {
//        return taskService.getAllTask();
//    }
//
//    @GetMapping("/api/tasks/{taskId}")
//    public Task getTaskById(Long taskId) {
//        return taskService.getTaskById(taskId);
//    }
//
//    @PostMapping("/api/tasks")
//    public Task createTask(Task task) {
//        return taskService.createTask(task);
//    }
//
//    @PutMapping("/api/tasks/{taskId}")
//    public Task updateTaskById(Long taskId, Task task) {
//        return taskService.updateTaskById(taskId, task);
//    }
//
//    @DeleteMapping("/api/tasks/{taskId}")
//    public void deleteTaskById(Long taskId) {
//        taskService.deleteTaskById(taskId);
//    }
//
//
//    //###################Comment Api###################
//
//    @GetMapping("/api/tasks/comment")
//    public List<Comment> getAllComment() {
//        return taskService.getAllComment();
//    }
//
//    @GetMapping("/api/tasks/comment/{commentId}")
//    public Comment getCommentById(Long commentId) {
//        return taskService.getCommentById(commentId);
//    }
//
//    @PostMapping("/api/tasks/comment")
//    public Comment createComment(Comment comment) {
//        return taskService.createComment(comment);
//    }
//
//    @PutMapping("/api/tasks/comment/{commentId}")
//    public Comment updateCommentById(Long commentId, Comment comment) {
//        return taskService.updateCommentById(commentId, comment);
//    }
//
//    @DeleteMapping("/api/tasks/comment/{commentId}")
//    public void deleteCommentById(Long commentId) {
//        taskService.deleteCommentById(commentId);
//    }



