package com.nhnacademy.minidooraytaskapi.service;

import com.nhnacademy.minidooraytaskapi.dto.TagDto;
import com.nhnacademy.minidooraytaskapi.dto.TaskDto;
import com.nhnacademy.minidooraytaskapi.entity.Tag;
import com.nhnacademy.minidooraytaskapi.entity.Task;
import com.nhnacademy.minidooraytaskapi.entity.TaskTag;
import com.nhnacademy.minidooraytaskapi.repository.TagRepository;
import com.nhnacademy.minidooraytaskapi.repository.TaskRepository;
import com.nhnacademy.minidooraytaskapi.repository.TaskTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskTagService {
    private final TaskTagRepository taskTagRepository;

    private final TaskRepository taskRepository;

    private final TagRepository tagRepository;

    @Transactional
    public void createTaskTag(Long taskId, Long tagId) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        Tag tag = tagRepository.findById(tagId).orElseThrow();

        TaskTag taskTag = new TaskTag();
        TaskTag.Pk pk = new TaskTag.Pk();

        pk.setTask(task);
        pk.setTag(tag);
        taskTag.setPk(pk);
        taskTagRepository.save(taskTag);
    }

    @Transactional(readOnly = true)
    public List<TagDto> getTagsByTask(Long taskId) {
        List<TaskTag> taskTags = taskTagRepository.findTaskTagsByPkTaskTaskId(taskId);
        List<TagDto> tagDtos = new ArrayList<>();
        for (TaskTag taskTag : taskTags) {
            TagDto tagDto = new TagDto();
            tagDto.setTagId(taskTag.getPk().getTag().getTagId());
            tagDto.setTagName(taskTag.getPk().getTag().getTagName());
            tagDtos.add(tagDto);
        }
        return tagDtos;
    }

    @Transactional(readOnly = true)
    public List<TaskDto> getTasksByTag(Long tagId) {
        List<TaskTag> taskTags = taskTagRepository.findTaskTagsByPkTagTagId(tagId);
        List<TaskDto> taskDtos = new ArrayList<>();
        for (TaskTag taskTag : taskTags) {
            TaskDto taskDto = new TaskDto();
            taskDto.setTaskId(taskTag.getPk().getTask().getTaskId());
            taskDto.setTaskName(taskTag.getPk().getTask().getTaskName());
            taskDtos.add(taskDto);
        }
        return taskDtos;
    }

    @Transactional
    public void deleteTaskTag(Long taskId, Long tagId) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        Tag tag = tagRepository.findById(tagId).orElseThrow();

        TaskTag taskTag = new TaskTag();
        TaskTag.Pk pk = new TaskTag.Pk();

        pk.setTask(task);
        pk.setTag(tag);
        taskTag.setPk(pk);
        taskTagRepository.delete(taskTag);

    }
}
