package com.nhnacademy.minidooraytaskapi.service;

import com.nhnacademy.minidooraytaskapi.dto.ProjectCreateDto;
import com.nhnacademy.minidooraytaskapi.dto.ProjectDto;
import com.nhnacademy.minidooraytaskapi.dto.TaskCreateDto;
import com.nhnacademy.minidooraytaskapi.dto.TaskDto;
import com.nhnacademy.minidooraytaskapi.entity.Comment;
import com.nhnacademy.minidooraytaskapi.entity.MilestoneTask;
import com.nhnacademy.minidooraytaskapi.entity.Project;
import com.nhnacademy.minidooraytaskapi.entity.Task;
import com.nhnacademy.minidooraytaskapi.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    private final UserTaskService userTaskService;

    private final CommentService commentService;

    private final TaskTagService taskTagService;

    private final MilestoneTaskService milestoneTaskService;


    @Transactional
    public void createTask(TaskCreateDto taskCreateDto) {
        Task task = new Task();
        task.setTaskName(taskCreateDto.getTaskName());
        task.setTaskContent(taskCreateDto.getTaskContent());
        task.setTaskCreationDate(taskCreateDto.getTaskCreationDate());
        task.setTaskEndDate(taskCreateDto.getTaskEndDate());
        task.setUser(userRepository.findByUserUUID(taskCreateDto.getUserUUID()));
        task.setProject(projectRepository.findByProjectId(taskCreateDto.getProjectId()));

        Task savedTask = taskRepository.save(task);

        userTaskService.createUserTask(taskCreateDto.getUserUUID(), savedTask.getTaskId());

    }

    @Transactional(readOnly = true)
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

    @Transactional
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


    @Transactional(readOnly = true)
    public List<TaskDto> getTaskByProjectId(Long projectId) {
        List<Task> tasks = taskRepository.findTasksByProjectProjectId(projectId);
        return taskListToDtoList(tasks);
    }

    @Transactional(readOnly = true)
    public List<TaskDto> getTaskByAdminUserUUID(String userUUID) {
        List<Task> tasks = taskRepository.findTasksByUserUserUUID(userUUID);
        return taskListToDtoList(tasks);
    }

    @Transactional
    public void deleteTaskById(Long taskId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (taskOptional.isPresent()) {
            commentService.deleteCommentByTaskId(taskId);
            userTaskService.deleteByTaskId(taskId);
            taskTagService.deleteTaskTagByTaskId(taskId);
            milestoneTaskService.deleteByTaskId(taskId);
            taskRepository.deleteById(taskId);
        }
    }

    @Transactional
    public void deleteTaskByProjectId(Long projectId) {
        List<Task> tasks = taskRepository.findTasksByProjectProjectId(projectId);
        for (Task task : tasks) {
            deleteTaskById(task.getTaskId());
        }
    }

    @Transactional(readOnly = true)
    public List<TaskDto> taskListToDtoList(List<Task> tasks) {
        List<TaskDto> taskDtos = new ArrayList<>();

        for (Task task : tasks) {
            taskDtos.add(toDto(task));
        }
        return taskDtos;
    }

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    public Task toEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setTaskId(taskDto.getTaskId());
        task.setTaskName(taskDto.getTaskName());
        task.setTaskContent(taskDto.getTaskContent());
        task.setTaskCreationDate(taskDto.getTaskCreationDate());
        task.setTaskEndDate(taskDto.getTaskEndDate());
        task.setUser(userRepository.findByUserUUID(taskDto.getUserUUID()));
        task.setProject(projectRepository.findByProjectId(taskDto.getProjectId()));
        return task;
    }
}
