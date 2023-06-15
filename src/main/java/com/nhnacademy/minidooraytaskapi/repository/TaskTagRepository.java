package com.nhnacademy.minidooraytaskapi.repository;

import com.nhnacademy.minidooraytaskapi.entity.TaskTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskTagRepository extends JpaRepository<TaskTag, TaskTag.Pk> {

    List<TaskTag> findTaskTagsByPkTaskTaskId(Long taskId);

    List<TaskTag> findTaskTagsByPkTagTagId(Long tagId);
}
