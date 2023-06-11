package com.nhnacademy.minidooraytaskapi.repository;

import com.nhnacademy.minidooraytaskapi.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    public Project findByProjectId(Long projectId);
}
