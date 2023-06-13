package com.nhnacademy.minidooraytaskapi.repository;

import com.nhnacademy.minidooraytaskapi.entity.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.tools.DocumentationTool;

public interface UserTaskRepository extends JpaRepository<UserTask, UserTask.Pk> {
    UserTask findByUserUUID(String userUUID);
}
