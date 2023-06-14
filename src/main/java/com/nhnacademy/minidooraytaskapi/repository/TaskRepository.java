package com.nhnacademy.minidooraytaskapi.repository;

import com.nhnacademy.minidooraytaskapi.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTaskName(String taskName);

    Task findByTaskId(Long taskId);

    List<Task> findTasksByProjectProjectId(Long projectId);

    List<Task> findTasksByUserUserUUID(String userUUID);

}
