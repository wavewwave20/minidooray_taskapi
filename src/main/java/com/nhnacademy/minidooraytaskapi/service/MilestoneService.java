package com.nhnacademy.minidooraytaskapi.service;

import com.nhnacademy.minidooraytaskapi.dto.MilestoneCreateDto;
import com.nhnacademy.minidooraytaskapi.dto.MilestoneDto;
import com.nhnacademy.minidooraytaskapi.entity.Milestone;
import com.nhnacademy.minidooraytaskapi.repository.MilestoneRepository;
import com.nhnacademy.minidooraytaskapi.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MilestoneService {
    private final MilestoneRepository milestoneRepository;
    private final MilestoneTaskService milestoneTaskService;

    private final ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public MilestoneDto findById(Long milestoneId) {
        return toDto(milestoneRepository.findById(milestoneId).orElseThrow());
    }

    @Transactional(readOnly = true)
    public List<MilestoneDto> findByProjectId(Long projectId) {
        List<Milestone> milestoneList = milestoneRepository.findMilestonesByProjectProjectId(projectId);
        List<MilestoneDto> milestoneDtoList = new ArrayList<>();
        for (Milestone milestone : milestoneList) {
            milestoneDtoList.add(toDto(milestone));
        }
        return milestoneDtoList;
    }

    @Transactional
    public void createMileStone(MilestoneCreateDto milestoneDto) {
        Milestone milestone = new Milestone();
        milestone.setMilestoneName(milestoneDto.getMilestoneName());
        milestone.setMilestoneStartDate(milestoneDto.getMilestoneStartDate());
        milestone.setMilestoneEndDate(milestoneDto.getMilestoneEndDate());
        milestone.setMilestoneStatus(milestoneDto.getMilestoneStatus());
        milestone.setProject(projectRepository.findById(milestoneDto.getProjectId()).orElseThrow());
        milestoneRepository.save(milestone);
    }

    @Transactional
    public void updateMileStone(Long milestoneId, MilestoneCreateDto milestoneDto) {
        Milestone milestone = milestoneRepository.findById(milestoneId).orElseThrow();
        milestone.setMilestoneName(milestoneDto.getMilestoneName());
        milestone.setMilestoneStartDate(milestoneDto.getMilestoneStartDate());
        milestone.setMilestoneEndDate(milestoneDto.getMilestoneEndDate());
        milestone.setMilestoneStatus(milestoneDto.getMilestoneStatus());
        milestoneRepository.save(milestone);
    }

    @Transactional
    public void deleteMileStone(Long milestoneId) {
        milestoneTaskService.deleteMilestoneTaskByMilestoneId(milestoneId);
        milestoneRepository.deleteById(milestoneId);
    }


    @Transactional(readOnly = true)
    public MilestoneDto toDto(Milestone milestone) {
        MilestoneDto milestoneDto = new MilestoneDto();
        milestoneDto.setMilestoneId(milestone.getMilestoneId());
        milestoneDto.setMilestoneName(milestone.getMilestoneName());
        milestoneDto.setMilestoneStartDate(milestone.getMilestoneStartDate());
        milestoneDto.setMilestoneEndDate(milestone.getMilestoneEndDate());
        milestoneDto.setMilestoneStatus(milestone.getMilestoneStatus());
        milestoneDto.setProjectId(milestone.getProject().getProjectId());
        return milestoneDto;
    }

    @Transactional
    public void deleteMilestoneByProjectId(Long projectId) {
        milestoneRepository.deleteMilestonesByProjectProjectId(projectId);
    }


}
