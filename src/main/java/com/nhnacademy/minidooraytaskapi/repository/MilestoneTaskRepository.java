package com.nhnacademy.minidooraytaskapi.repository;

import com.nhnacademy.minidooraytaskapi.entity.MilestoneTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MilestoneTaskRepository extends JpaRepository<MilestoneTask, MilestoneTask.Pk> {
    List<MilestoneTask> findMilestoneTasksByPkMilestoneMilestoneId(Long milestoneId);

    List<MilestoneTask> findMilestoneTasksByPkTaskTaskId(Long taskId);

    void deleteMilestoneTasksByPkTaskTaskId(Long taskId);
}
