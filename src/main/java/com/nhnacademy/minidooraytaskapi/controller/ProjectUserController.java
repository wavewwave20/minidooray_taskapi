package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.ProjectDto;
import com.nhnacademy.minidooraytaskapi.dto.UserGetDto;
import com.nhnacademy.minidooraytaskapi.service.ProjectUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class ProjectUserController {

    private final ProjectUserService projectUserService;

    public ProjectUserController(ProjectUserService projectUserService) {
        this.projectUserService = projectUserService;
    }


    @PostMapping("/projects/{projectId}/users/{userUUID}")
    public void addProjectUser(@PathVariable Long projectId, @PathVariable String userUUID) {
        projectUserService.addProjectUser(projectId, userUUID);
    }

    @GetMapping("/projects/{projectId}/users")
    public ResponseEntity<List<UserGetDto>> getProjectUserAll(@PathVariable Long projectId) {
        List<UserGetDto> userGetDtoList = projectUserService.getAllUsers(projectId);
        return ResponseEntity.ok(userGetDtoList);
    }

    @GetMapping("/users/{userUUID}/projects")
    public ResponseEntity<List<ProjectDto>> getProjectAllUser(@PathVariable String userUUID) {
        List<ProjectDto> projectDtoList = projectUserService.getAllProjects(userUUID);
        return ResponseEntity.ok(projectDtoList);
    }

    @DeleteMapping("/projects/{projectId}/users/{userUUID}")
    public void deleteProjectUser(@PathVariable Long projectId, @PathVariable String userUUID) {
        projectUserService.deleteProjectUser(projectId, userUUID);
    }

    @DeleteMapping("/projects/{projectId}/users")
    public void deleteProjectByProjectId(@PathVariable Long projectId) {
        projectUserService.deleteProjectByProjectId(projectId);
    }

}
