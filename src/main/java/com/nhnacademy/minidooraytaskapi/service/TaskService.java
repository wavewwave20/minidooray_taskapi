package com.nhnacademy.minidooraytaskapi.service;

import com.nhnacademy.minidooraytaskapi.dto.ProjectCreateDto;
import com.nhnacademy.minidooraytaskapi.dto.ProjectDto;
import com.nhnacademy.minidooraytaskapi.dto.TaskCreateDto;
import com.nhnacademy.minidooraytaskapi.dto.TaskDto;
import com.nhnacademy.minidooraytaskapi.entity.Comment;
import com.nhnacademy.minidooraytaskapi.entity.Project;
import com.nhnacademy.minidooraytaskapi.entity.Task;
import com.nhnacademy.minidooraytaskapi.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final ProjectRepository projectRepository;
    private final TagRepository tagRepository;
    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;
    private final UserTaskRepository userTaskRepository;

    private final UserRepository userRepository;


    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }


    public void createTask(TaskCreateDto taskCreateDto) {
        Task task = new Task();
        task.setTaskName(taskCreateDto.getTaskName());
        task.setTaskContent(taskCreateDto.getTaskContent());
        task.setTaskCreationDate(taskCreateDto.getTaskCreationDate());
        task.setTaskEndDate(taskCreateDto.getTaskEndDate());
        task.setUser(userRepository.findByUserUUID(taskCreateDto.getUserUUID()));
        task.setProject(projectRepository.findByProjectId(taskCreateDto.getProjectId()));

        taskRepository.save(task);
    }

    public TaskDto getTaskById(Long taskId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            TaskDto taskDto = new TaskDto();
            taskDto.setTaskId(task.getTaskId());
            taskDto.setTaskName(task.getTaskName());
            taskDto.setTaskContent(task.getTaskContent());
            taskDto.setTaskCreationDate(task.getTaskCreationDate());
            taskDto.setTaskEndDate(task.getTaskEndDate());
            taskDto.setUserUUID(task.getUser().getUserUUID());
            taskDto.setProjectId(task.getProject().getProjectId());
            return taskDto;
        } else {
            return null;
        }
    }

    public void updateTaskById(Long taskId, TaskCreateDto taskUpdateDto) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setTaskName(taskUpdateDto.getTaskName());
            task.setTaskContent(taskUpdateDto.getTaskContent());
            task.setTaskCreationDate(taskUpdateDto.getTaskCreationDate());
            task.setTaskEndDate(taskUpdateDto.getTaskEndDate());
            task.setUser(userRepository.findByUserUUID(taskUpdateDto.getUserUUID()));
            task.setProject(projectRepository.findByProjectId(taskUpdateDto.getProjectId()));
            taskRepository.save(task);
        }
    }

    public void deleteTaskById(Long taskId) {
        taskRepository.deleteById(taskId);
    }


    //#TODO:기능별로 분화시켜서 별도 Service 클래스로 변경 필요
    //#TODO:상위 프로젝트-하위TASK-하위COMMENT-모두 관장하는 Tag에 대해 정리 필요(조회시 조건?)
    //#################### Project ####################
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProjectById(Long projectId, Project project) {
        //#TODO:프로젝트 레포지토리에서 그대로 가져와서 저장하는지(ProjectId가 변경되지 않는지)확인 필요
        return projectRepository.save(project);
    }

    public void deleteProjectById(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    //#################### Task ####################


    //#################### Comment ####################


    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }


    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateCommentById(Long commentId, Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public TaskDto getTaskByName(String taskName) {
        return toDto(taskRepository.findByTaskName(taskName));
    }

    public TaskDto toDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskId(task.getTaskId());
        taskDto.setTaskName(task.getTaskName());
        taskDto.setTaskContent(task.getTaskContent());
        taskDto.setTaskCreationDate(task.getTaskCreationDate());
        taskDto.setTaskEndDate(task.getTaskEndDate());
        taskDto.setUserUUID(task.getUser().getUserUUID());
        taskDto.setProjectId(task.getProject().getProjectId());
        return taskDto;
    }
}
