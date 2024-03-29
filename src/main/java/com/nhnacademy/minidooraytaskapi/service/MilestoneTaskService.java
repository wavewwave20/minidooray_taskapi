package com.nhnacademy.minidooraytaskapi.service;

import com.nhnacademy.minidooraytaskapi.dto.MilestoneDto;
import com.nhnacademy.minidooraytaskapi.dto.TaskDto;
import com.nhnacademy.minidooraytaskapi.entity.Milestone;
import com.nhnacademy.minidooraytaskapi.entity.MilestoneTask;
import com.nhnacademy.minidooraytaskapi.entity.Task;
import com.nhnacademy.minidooraytaskapi.repository.MilestoneRepository;
import com.nhnacademy.minidooraytaskapi.repository.MilestoneTaskRepository;
import com.nhnacademy.minidooraytaskapi.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MilestoneTaskService {
    private final MilestoneTaskRepository milestoneTaskRepository;

    private final MilestoneRepository milestoneRepository;

    private final TaskRepository taskRepository;

    @Transactional(readOnly = true)
    public List<MilestoneDto> getMilestonesByTask(Long taskId) {
        List<MilestoneTask> milestoneTasks = milestoneTaskRepository.findMilestoneTasksByPkTaskTaskId(taskId);
        List<MilestoneDto> milestoneDtos = new ArrayList<>();

        for(MilestoneTask milestoneTask : milestoneTasks) {
            Milestone milestone = milestoneTask.getPk().getMilestone();
            MilestoneDto milestoneDto = new MilestoneDto();
            milestoneDto.setMilestoneId(milestone.getMilestoneId());
            milestoneDto.setMilestoneName(milestone.getMilestoneName());
            milestoneDto.setMilestoneStartDate(milestone.getMilestoneStartDate());
            milestoneDto.setMilestoneEndDate(milestone.getMilestoneEndDate());
            milestoneDto.setMilestoneStatus(milestone.getMilestoneStatus());
            milestoneDto.setProjectId(milestoneTask.getPk().getMilestone().getProject().getProjectId());
            milestoneDtos.add(milestoneDto);
        }
        return milestoneDtos;
    }

    @Transactional(readOnly = true)
    public List<TaskDto> getTasksByMilestone(Long milestoneId) {
        List<MilestoneTask> milestoneTasks = milestoneTaskRepository.findMilestoneTasksByPkMilestoneMilestoneId(milestoneId);
        List<TaskDto> taskDtos = new ArrayList<>();

        for(MilestoneTask milestoneTask : milestoneTasks) {
            Task task = milestoneTask.getPk().getTask();
            TaskDto taskDto = new TaskDto();
            taskDto.setTaskId(task.getTaskId());
            taskDto.setTaskName(task.getTaskName());
            taskDto.setTaskContent(task.getTaskContent());
            taskDto.setTaskEndDate(task.getTaskEndDate());
            taskDto.setTaskCreationDate(task.getTaskCreationDate());
            taskDto.setUserUUID(milestoneTask.getPk().getTask().getUser().getUserUUID());
            taskDto.setProjectId(milestoneTask.getPk().getTask().getProject().getProjectId());
            taskDtos.add(taskDto);
        }
        return taskDtos;
    }

    @Transactional
    public void createMilestoneTask(Long milestoneId, Long taskId) {
        MilestoneTask milestoneTask = toEntity(milestoneId, taskId);
        milestoneTaskRepository.save(milestoneTask);
    }

    @Transactional
    public void deleteMilestoneTask(Long milestoneId, Long taskId) {
        MilestoneTask milestoneTask = toEntity(milestoneId, taskId);
        milestoneTaskRepository.delete(milestoneTask);
    }

    @Transactional
    public void deleteMilestoneTaskByMilestoneId(Long milestoneId) {
        List<MilestoneTask> milestoneTasks = milestoneTaskRepository.findMilestoneTasksByPkMilestoneMilestoneId(milestoneId);
        for(MilestoneTask milestoneTask : milestoneTasks) {
            milestoneTaskRepository.delete(milestoneTask);
        }
    }

    @Transactional
    public void deleteByTaskId(Long taskId) {
        milestoneTaskRepository.deleteMilestoneTasksByPkTaskTaskId(taskId);
    }

    @Transactional(readOnly = true)
    public MilestoneTask toEntity(Long milestoneId, Long taskId) {
        MilestoneTask milestoneTask = new MilestoneTask();
        MilestoneTask.Pk pk = new MilestoneTask.Pk();
        pk.setMilestone(milestoneRepository.findByMilestoneId(milestoneId));
        pk.setTask(taskRepository.findByTaskId(taskId));
        milestoneTask.setPk(pk);
        return milestoneTask;
    }
}
