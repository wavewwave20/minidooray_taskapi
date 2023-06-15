package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.MilestoneCreateDto;
import com.nhnacademy.minidooraytaskapi.dto.MilestoneDto;
import com.nhnacademy.minidooraytaskapi.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class MilestoneController {

    private final MilestoneService milestoneService;

    @GetMapping("/milestones/{milestoneId}")
    public ResponseEntity<MilestoneDto> getMileStone(@PathVariable Long milestoneId) {
        MilestoneDto milestoneDto = milestoneService.findById(milestoneId);
        return ResponseEntity.ok(milestoneDto);
    }

    @GetMapping("/milestones/projects/{projectId}")
    public ResponseEntity<List<MilestoneDto>> getMileStoneList(@PathVariable Long projectId) {
        List<MilestoneDto> milestoneDtos = milestoneService.findByProjectId(projectId);
        return ResponseEntity.ok(milestoneDtos);
    }

    @PostMapping("/milestones")
    public void createMileStone(@RequestBody MilestoneCreateDto milestoneDto) {
        milestoneService.createMileStone(milestoneDto);
    }

    @PutMapping("/milestones/{milestoneId}")
    public void updateMileStone(@PathVariable Long milestoneId, @RequestBody MilestoneCreateDto milestoneDto) {
        milestoneService.updateMileStone(milestoneId, milestoneDto);
    }

    @DeleteMapping("/milestones/{milestoneId}")
    public void deleteMileStone(@PathVariable Long milestoneId) {
        milestoneService.deleteMileStone(milestoneId);
    }


}
