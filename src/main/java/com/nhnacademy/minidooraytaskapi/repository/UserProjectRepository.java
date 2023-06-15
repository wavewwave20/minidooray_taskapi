package com.nhnacademy.minidooraytaskapi.repository;

import com.nhnacademy.minidooraytaskapi.entity.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProjectRepository extends JpaRepository<UserProject, UserProject.Pk> {

    List<UserProject> findByPkProjectProjectId(Long projectId);

    List<UserProject> findByPkUserUserUUID(String userUUID);

    void deleteUserProjectByPkProjectProjectIdAndPkUserUserUUID(Long projectId, String userUUID);

    void deleteUserProjectsByPkProjectProjectId(Long projectId);

}
