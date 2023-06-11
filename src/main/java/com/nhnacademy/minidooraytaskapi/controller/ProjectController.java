package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.ProjectCreateDto;
import com.nhnacademy.minidooraytaskapi.dto.ProjectDto;
import com.nhnacademy.minidooraytaskapi.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taskapi/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @PostMapping("/create")
    public void createProject(@RequestBody ProjectCreateDto projectCreateDto) {
        projectService.projectCreate(projectCreateDto);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable Long projectId) {
        ProjectDto projectDto = projectService.getProjectById(projectId);
        return ResponseEntity.ok(projectDto);
    }

    //update를 그냥 create으로 사용?
    @PutMapping("/{projectId}")
    public void updateProjectById(@PathVariable Long projectId, @RequestBody ProjectDto projectDto) {
        projectService.updateProjectById(projectId, projectDto);
    }

    @DeleteMapping("/{projectId}")
    public void deleteProjectById(@PathVariable Long projectId) {
        //projectService.deleteProjectById(projectId);
    }



}
