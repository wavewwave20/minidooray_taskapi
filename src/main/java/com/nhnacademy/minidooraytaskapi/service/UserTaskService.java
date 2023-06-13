package com.nhnacademy.minidooraytaskapi.service;

import com.nhnacademy.minidooraytaskapi.dto.UserGetDto;
import com.nhnacademy.minidooraytaskapi.entity.Task;
import com.nhnacademy.minidooraytaskapi.entity.User;
import com.nhnacademy.minidooraytaskapi.entity.UserTask;
import com.nhnacademy.minidooraytaskapi.repository.TaskRepository;
import com.nhnacademy.minidooraytaskapi.repository.UserTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTaskService {
    private final UserTaskRepository userTaskRepository;
    private final TaskRepository taskRepository;

    public void createUserTask(User userEntity, Task taskEntity) {
        UserTask userTask = new UserTask();
        UserTask.Pk pk = new UserTask.Pk();
        pk.setUser(userEntity);
        pk.setTask(taskEntity);
        userTask.setPk(pk);
        userTaskRepository.save(userTask);
    }

    public UserGetDto getUserByTaskName(String taskName) {
        UserTask userTask = userTaskRepository.findUserByTask(taskRepository.findByTaskName(taskName));
        UserGetDto userGetDto = new UserGetDto();
        userGetDto.setUserNickName(userTask.getPk().getUser().getUserNickname());
        userGetDto.setUserUUID(userTask.getPk().getUser().getUserUUID());
        userGetDto.setUserEmail(userTask.getPk().getUser().getUserEmail());
        userGetDto.setUserId(userTask.getPk().getUser().getUserId());
        return userGetDto;
    }
}
