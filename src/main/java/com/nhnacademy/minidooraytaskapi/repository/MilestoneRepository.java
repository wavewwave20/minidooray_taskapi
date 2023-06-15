package com.nhnacademy.minidooraytaskapi.repository;

import com.nhnacademy.minidooraytaskapi.entity.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
    Milestone findByMilestoneId(Long milestoneId);

    List<Milestone> findMilestonesByProjectProjectId(Long projectId);

    void deleteMilestonesByProjectProjectId(Long projectId);
}
