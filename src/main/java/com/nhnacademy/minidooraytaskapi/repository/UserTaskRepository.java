package com.nhnacademy.minidooraytaskapi.repository;

import com.nhnacademy.minidooraytaskapi.entity.Task;
import com.nhnacademy.minidooraytaskapi.entity.User;
import com.nhnacademy.minidooraytaskapi.entity.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.tools.DocumentationTool;

public interface UserTaskRepository extends JpaRepository<UserTask, UserTask.Pk> {
    //#TODO: 여기있는거 다 되는지 확인해봐야할듯함여
    UserTask findByUserUUID(String userUUID);

    UserTask findUserByTask(Task byTaskName);

}
