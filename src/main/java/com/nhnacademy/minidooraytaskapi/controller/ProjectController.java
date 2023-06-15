package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.ProjectCreateDto;
import com.nhnacademy.minidooraytaskapi.dto.ProjectDto;
import com.nhnacademy.minidooraytaskapi.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @PostMapping("/project")
    public void createProject(@RequestBody ProjectCreateDto projectCreateDto) {
        projectService.projectCreate(projectCreateDto);
    }

    @GetMapping("/project?project={projectId}")
    public ResponseEntity<ProjectDto> getProjectById(@RequestParam Long projectId) {
        ProjectDto projectDto = projectService.getProjectById(projectId);
        return ResponseEntity.ok(projectDto);
    }

    //update를 그냥 create으로 사용?
    @PutMapping("/project?project={projectId}")
    public void updateProjectById(@RequestParam Long projectId, @RequestBody ProjectDto projectDto) {
        projectService.updateProjectById(projectId, projectDto);
    }

    @DeleteMapping("/project?project={projectId}")
    public void deleteProjectById(@RequestParam Long projectId) {
        projectService.deleteProjectById(projectId);
    }



}
