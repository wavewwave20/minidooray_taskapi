package com.nhnacademy.minidooraytaskapi.repository;


import com.nhnacademy.minidooraytaskapi.entity.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserTaskRepository extends JpaRepository<UserTask, UserTask.Pk> {
    UserTask findUserTaskByPkUserUserUUID(String userUUID);

    List<UserTask> findUserTasksByPkTaskTaskId(Long taskId);

    List<UserTask> findUserTasksByPkUserUserUUID(String userUUID);

}
