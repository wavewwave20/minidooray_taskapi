package com.nhnacademy.minidooraytaskapi.repository;

import com.nhnacademy.minidooraytaskapi.entity.MilestoneTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilestoneTaskRepository extends JpaRepository<MilestoneTask, MilestoneTask.Pk> {
}
