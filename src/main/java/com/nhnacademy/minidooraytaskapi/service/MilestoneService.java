package com.nhnacademy.minidooraytaskapi.service;

import com.nhnacademy.minidooraytaskapi.dto.MilestoneDto;
import com.nhnacademy.minidooraytaskapi.entity.Milestone;
import com.nhnacademy.minidooraytaskapi.repository.MilestoneRepository;
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
    public void createMileStone(MilestoneDto milestoneDto) {
        milestoneRepository.save(toEntity(milestoneDto));
    }

    @Transactional
    public void updateMileStone(Long milestoneId, MilestoneDto milestoneDto) {
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
    private MilestoneDto toDto(Milestone milestone) {
        MilestoneDto milestoneDto = new MilestoneDto();
        milestoneDto.setMilestoneId(milestone.getMilestoneId());
        milestoneDto.setMilestoneName(milestone.getMilestoneName());
        milestoneDto.setMilestoneStartDate(milestone.getMilestoneStartDate());
        milestoneDto.setMilestoneEndDate(milestone.getMilestoneEndDate());
        milestoneDto.setMilestoneStatus(milestone.getMilestoneStatus());
        return milestoneDto;
    }

    @Transactional(readOnly = true)
    private Milestone toEntity(MilestoneDto milestoneDto) {
        Milestone milestone = new Milestone();
        milestone.setMilestoneId(milestoneDto.getMilestoneId());
        milestone.setMilestoneName(milestoneDto.getMilestoneName());
        milestone.setMilestoneStartDate(milestoneDto.getMilestoneStartDate());
        milestone.setMilestoneEndDate(milestoneDto.getMilestoneEndDate());
        milestone.setMilestoneStatus(milestoneDto.getMilestoneStatus());
        return milestone;
    }

    @Transactional
    void deleteMilestoneByProjectId(Long projectId) {
        milestoneRepository.deleteMilestonesByProjectProjectId(projectId);
    }


}
