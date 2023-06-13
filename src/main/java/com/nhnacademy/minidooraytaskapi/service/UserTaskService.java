package com.nhnacademy.minidooraytaskapi.service;

import com.nhnacademy.minidooraytaskapi.entity.Task;
import com.nhnacademy.minidooraytaskapi.entity.User;
import com.nhnacademy.minidooraytaskapi.entity.UserTask;
import com.nhnacademy.minidooraytaskapi.repository.UserTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTaskService {
    private final UserTaskRepository userTaskRepository;

    public void createUserTask(User userEntity, Task taskEntity) {
        UserTask userTask = new UserTask();
        UserTask.Pk pk = new UserTask.Pk();
        pk.setUser(userEntity);
        pk.setTask(taskEntity);
        userTask.setPk(pk);
        userTaskRepository.save(userTask);
    }
}
