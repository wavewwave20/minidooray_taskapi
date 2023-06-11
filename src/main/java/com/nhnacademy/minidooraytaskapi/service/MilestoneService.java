package com.nhnacademy.minidooraytaskapi.service;

import com.nhnacademy.minidooraytaskapi.dto.MilestoneDto;
import com.nhnacademy.minidooraytaskapi.entity.Milestone;
import com.nhnacademy.minidooraytaskapi.repository.MilestoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MilestoneService {
    private final MilestoneRepository milestoneRepository;

    public MilestoneDto findById(Long milestoneId) {
        return toDto(milestoneRepository.findById(milestoneId).orElseThrow());
    }

    public void createMileStone(MilestoneDto milestoneDto) {
        milestoneRepository.save(toEntity(milestoneDto));

    }

    public void updateMileStone(Long milestoneId, MilestoneDto milestoneDto) {
        Milestone milestone = milestoneRepository.findById(milestoneId).orElseThrow();
        milestone.setMilestoneName(milestoneDto.getMilestoneName());
        milestone.setMilestoneStartDate(milestoneDto.getMilestoneStartDate());
        milestone.setMilestoneEndDate(milestoneDto.getMilestoneEndDate());
        milestone.setMilestoneStatus(milestoneDto.getMilestoneStatus());
        milestoneRepository.save(milestone);
    }

    public void deleteMileStone(Long milestoneId) {
        milestoneRepository.deleteById(milestoneId);
    }


    private MilestoneDto toDto(Milestone milestone) {
        MilestoneDto milestoneDto = new MilestoneDto();
        milestoneDto.setMilestoneId(milestone.getMilestoneId());
        milestoneDto.setMilestoneName(milestone.getMilestoneName());
        milestoneDto.setMilestoneStartDate(milestone.getMilestoneStartDate());
        milestoneDto.setMilestoneEndDate(milestone.getMilestoneEndDate());
        milestoneDto.setMilestoneStatus(milestone.getMilestoneStatus());
        return milestoneDto;
    }

    private Milestone toEntity(MilestoneDto milestoneDto) {
        Milestone milestone = new Milestone();
        milestone.setMilestoneId(milestoneDto.getMilestoneId());
        milestone.setMilestoneName(milestoneDto.getMilestoneName());
        milestone.setMilestoneStartDate(milestoneDto.getMilestoneStartDate());
        milestone.setMilestoneEndDate(milestoneDto.getMilestoneEndDate());
        milestone.setMilestoneStatus(milestoneDto.getMilestoneStatus());
        return milestone;
    }


}
