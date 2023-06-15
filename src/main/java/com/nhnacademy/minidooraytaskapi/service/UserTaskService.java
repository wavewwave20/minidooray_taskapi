package com.nhnacademy.minidooraytaskapi.service;

import com.nhnacademy.minidooraytaskapi.dto.UserTaskCreateDto;
import com.nhnacademy.minidooraytaskapi.entity.Task;
import com.nhnacademy.minidooraytaskapi.entity.User;
import com.nhnacademy.minidooraytaskapi.entity.UserTask;
import com.nhnacademy.minidooraytaskapi.repository.TaskRepository;
import com.nhnacademy.minidooraytaskapi.repository.UserRepository;
import com.nhnacademy.minidooraytaskapi.repository.UserTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTaskService {
    private final UserTaskRepository userTaskRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;


    @Transactional
    public void createUserTask(Long taskId, String userUUID) {
        UserTask userTask = new UserTask();
        UserTask.Pk pk = new UserTask.Pk();

        User userEntity = userRepository.findByUserUUID(userUUID);
        Task taskEntity = taskRepository.findByTaskId(taskId);

        pk.setUser(userEntity);
        pk.setTask(taskEntity);
        userTask.setPk(pk);
        userTaskRepository.save(userTask);
    }


    @Transactional
    public void deleteByTaskId(Long taskId) {
        List<UserTask> userTasks = userTaskRepository.findUserTasksByPkTaskTaskId(taskId);
        for(UserTask ut : userTasks) {
            userTaskRepository.delete(ut);
        }
    }

    @Transactional(readOnly = true)
    public List<UserTaskCreateDto> getUserTaskByUserId(String userUUID) {
        List<UserTask> userTasks = userTaskRepository.findUserTasksByPkUserUserUUID(userUUID);
        List<UserTaskCreateDto> userTaskCreateDtos = new ArrayList<>();

        for (UserTask ut : userTasks) {
            UserTaskCreateDto userTaskCreateDto = new UserTaskCreateDto();
            userTaskCreateDto.setTaskId(ut.getPk().getTask().getTaskId());
            userTaskCreateDto.setUserUUID(ut.getPk().getUser().getUserUUID());
            userTaskCreateDtos.add(userTaskCreateDto);
        }
        return userTaskCreateDtos;
    }

    @Transactional(readOnly = true)
    public List<UserTaskCreateDto> getUserTaskByTaskId(Long taskId) {
        List<UserTask> userTasks = userTaskRepository.findUserTasksByPkTaskTaskId(taskId);
        List<UserTaskCreateDto> userTaskCreateDtos = new ArrayList<>();

        for (UserTask ut : userTasks) {
            UserTaskCreateDto userTaskCreateDto = new UserTaskCreateDto();
            userTaskCreateDto.setTaskId(ut.getPk().getTask().getTaskId());
            userTaskCreateDto.setUserUUID(ut.getPk().getUser().getUserUUID());
            userTaskCreateDtos.add(userTaskCreateDto);
        }
        return userTaskCreateDtos;

    }

    @Transactional
    public void deleteUserTask(Long taskId, String userUUID){
        UserTask.Pk pk = new UserTask.Pk();
        User userEntity = userRepository.findByUserUUID(userUUID);
        Task taskEntity = taskRepository.findByTaskId(taskId);
        pk.setTask(taskEntity);
        pk.setUser(userEntity);
        userTaskRepository.deleteById(pk);
    }
}
