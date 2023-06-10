package com.nhnacademy.minidooraytaskapi.service;

import com.nhnacademy.minidooraytaskapi.entity.Comment;
import com.nhnacademy.minidooraytaskapi.entity.Project;
import com.nhnacademy.minidooraytaskapi.entity.Task;
import com.nhnacademy.minidooraytaskapi.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final ProjectRepository projectRepository;
    private final TagRepository tagRepository;
    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;
    private final UserTaskRepository userTaskRepository;

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
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }


    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTaskById(Long taskId, Task task) {
        //#TODO:위와 같이 그대로 저장하는지에 대한 확인 필요(TaskId에 대해 영향을 미치지 않는지)
        return taskRepository.save(task);
    }

    public void deleteTaskById(Long taskId) {
        taskRepository.deleteById(taskId);
    }

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
}
