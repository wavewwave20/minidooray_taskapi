package com.nhnacademy.minidooraytaskapi.service;

import com.nhnacademy.minidooraytaskapi.dto.ProjectDto;
import com.nhnacademy.minidooraytaskapi.dto.UserGetDto;
import com.nhnacademy.minidooraytaskapi.entity.Project;
import com.nhnacademy.minidooraytaskapi.entity.User;
import com.nhnacademy.minidooraytaskapi.entity.UserProject;
import com.nhnacademy.minidooraytaskapi.repository.ProjectRepository;
import com.nhnacademy.minidooraytaskapi.repository.UserProjectRepository;
import com.nhnacademy.minidooraytaskapi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectUserService {

    private final UserProjectRepository userProjectRepository;

    private final ProjectRepository projectRepository;

    private final UserRepository userRepository;


    public ProjectUserService(UserProjectRepository userProjectRepository, ProjectRepository projectRepository, UserRepository userRepository) {
        this.userProjectRepository = userProjectRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }


    @Transactional
    public void addProjectUser(Long projectId, String userUUID) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        User user = userRepository.findByUserUUID(userUUID);

        UserProject.Pk pk = new UserProject.Pk();
        pk.setProject(project);
        pk.setUser(user);

        UserProject userProject = new UserProject();
        userProject.setPk(pk);

        userProjectRepository.save(userProject);
    }


    @Transactional(readOnly = true)
    public List<UserGetDto> getAllUsers(Long projectId) {
        List<UserProject> userProjectList = userProjectRepository.findByPkProjectProjectId(projectId);
        List<UserGetDto> userGetDtoList = new ArrayList<>();

        for (UserProject userProject : userProjectList) {
            User user = userProject.getPk().getUser();
            UserGetDto userGetDto = new UserGetDto();
            userGetDto.setUserUUID(user.getUserUUID());
            userGetDto.setUserId(user.getUserId());
            userGetDto.setUserEmail(user.getUserEmail());
            userGetDto.setUserEmail(user.getUserEmail());
            userGetDtoList.add(userGetDto);
        }
        return userGetDtoList;
    }

    @Transactional(readOnly = true)
    public List<ProjectDto> getAllProjects(String userUUID) {
        List<UserProject> userProjectList = userProjectRepository.findByPkUserUserUUID(userUUID);
        List<ProjectDto> projectDtoList = new ArrayList<>();

        for (UserProject userProject : userProjectList) {
            Project project = userProject.getPk().getProject();
            ProjectDto projectDto = new ProjectDto();
            projectDto.setProjectId(project.getProjectId());
            projectDto.setProjectName(project.getProjectName());
            projectDto.setProjectDescription(project.getProjectDescription());
            projectDto.setProjectStatus(project.getProjectStatus());
            projectDto.setUserUUID(userUUID);
            projectDtoList.add(projectDto);
        }
        return projectDtoList;
    }

    @Transactional
    public void deleteProjectUser(Long projectId, String userUUID) {
        userProjectRepository.deleteUserProjectByPkProjectProjectIdAndPkUserUserUUID(projectId, userUUID);
    }

    @Transactional
    public void deleteProjectByProjectId(Long projectId) {
        userProjectRepository.deleteUserProjectsByPkProjectProjectId(projectId);
    }

}
