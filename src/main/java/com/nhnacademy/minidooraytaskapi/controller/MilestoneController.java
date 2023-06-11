package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.MilestoneDto;
import com.nhnacademy.minidooraytaskapi.entity.Milestone;
import com.nhnacademy.minidooraytaskapi.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/taskapi/milestones")
public class MilestoneController {

    private final MilestoneService milestoneService;

    @GetMapping("/{id}")
    public MilestoneDto getMileStone(@PathVariable Long milestoneId) {
        return milestoneService.findById(milestoneId);
    }

    @PostMapping("/")
    public void createMileStone(@RequestBody MilestoneDto milestoneDto) {
        milestoneService.createMileStone(milestoneDto);
    }

    @PutMapping("/{id}")
    public void updateMileStone(@PathVariable Long milestoneId, @RequestBody MilestoneDto milestoneDto) {
        milestoneService.updateMileStone(milestoneId, milestoneDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMileStone(@PathVariable Long milestoneId) {
        milestoneService.deleteMileStone(milestoneId);
    }


}
