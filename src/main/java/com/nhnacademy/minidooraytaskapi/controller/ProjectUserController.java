package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.ProjectDto;
import com.nhnacademy.minidooraytaskapi.dto.UserGetDto;
import com.nhnacademy.minidooraytaskapi.service.ProjectUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectUserController {

    private final ProjectUserService projectUserService;

    public ProjectUserController(ProjectUserService projectUserService) {
        this.projectUserService = projectUserService;
    }


    @PostMapping("/project-user?project={projectId}&user={userUUID}")
    public void addProjectUser(@PathVariable Long projectId, @PathVariable String userUUID) {
        projectUserService.addProjectUser(projectId, userUUID);
    }

    @GetMapping("/project-user/list?project={projectId}")
    public ResponseEntity<List<UserGetDto>> getProjectUserAll(@PathVariable Long projectId) {
        List<UserGetDto> userGetDtoList = projectUserService.getAllUsers(projectId);
        return ResponseEntity.ok(userGetDtoList);
    }

    @GetMapping("/project-user/list?user={userUUID}")
    public ResponseEntity<List<ProjectDto>> getProjectAllUser(@PathVariable String userUUID) {
        List<ProjectDto> projectDtoList = projectUserService.getAllProjects(userUUID);
        return ResponseEntity.ok(projectDtoList);
    }

    @DeleteMapping("/project-user?project={projectId}&user={userUUID}")
    public void deleteProjectUser(@PathVariable Long projectId, @PathVariable String userUUID) {
        projectUserService.deleteProjectUser(projectId, userUUID);
    }

    @DeleteMapping("/project-user?project={projectId}")
    public void deleteProjectByProjectId(@PathVariable Long projectId) {
        projectUserService.deleteProjectByProjectId(projectId);
    }


}
