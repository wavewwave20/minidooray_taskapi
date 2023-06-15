package com.nhnacademy.minidooraytaskapi.service;

import com.nhnacademy.minidooraytaskapi.dto.ProjectCreateDto;
import com.nhnacademy.minidooraytaskapi.dto.ProjectDto;
import com.nhnacademy.minidooraytaskapi.entity.Project;
import com.nhnacademy.minidooraytaskapi.repository.ProjectRepository;
import com.nhnacademy.minidooraytaskapi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    private final UserRepository userRepository;

    private final TaskService taskService;

    private final TagService tagService;

    private final MilestoneService milestoneService;

    private final ProjectUserService projectUserService;

    public ProjectService(ProjectRepository projectRepository, UserRepository userRepository, TaskService taskService, TagService tagService, MilestoneService milestoneService, ProjectUserService projectUserService) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.taskService = taskService;
        this.tagService = tagService;
        this.milestoneService = milestoneService;
        this.projectUserService = projectUserService;
    }

    @Transactional
    public void projectCreate(ProjectCreateDto projectCreateDto) {

        Project project = new Project();
        project.setProjectName(projectCreateDto.getProjectName());
        project.setProjectDescription(projectCreateDto.getProjectDescription());
        project.setProjectStatus(projectCreateDto.getProjectStatus());
        project.setUser(userRepository.findByUserUUID(projectCreateDto.getUserUUID()));

        projectRepository.save(project);
    }

    @Transactional(readOnly = true)
    public ProjectDto getProjectById(Long projectId) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);

        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            ProjectDto projectDto = new ProjectDto();
            projectDto.setProjectId(project.getProjectId());
            projectDto.setProjectName(project.getProjectName());
            projectDto.setProjectDescription(project.getProjectDescription());
            projectDto.setProjectStatus(project.getProjectStatus());
            projectDto.setUserUUID(project.getUser().getUserUUID());
            return projectDto;
        } else {
            return null;
        }
    }

    @Transactional
    public void updateProjectById(Long projectId, ProjectDto projectDto) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);

        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            project.setProjectName(projectDto.getProjectName());
            project.setProjectDescription(projectDto.getProjectDescription());
            project.setProjectStatus(projectDto.getProjectStatus());
            project.setUser(userRepository.findByUserUUID(projectDto.getUserUUID()));

            projectRepository.save(project);
        }
    }

    @Transactional
    public void deleteProjectById(Long projectId) {
        Optional<Project> project = projectRepository.findById(projectId);

        if (project.isPresent()) {
            taskService.deleteTaskByProjectId(projectId);
            tagService.deleteTagByProjectId(projectId);
            milestoneService.deleteMilestoneByProjectId(projectId);
            projectUserService.deleteProjectByProjectId(projectId);
            projectRepository.deleteById(projectId);
        }
    }
}
