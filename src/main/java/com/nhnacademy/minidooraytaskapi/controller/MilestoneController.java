package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.MilestoneDto;
import com.nhnacademy.minidooraytaskapi.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MilestoneController {

    private final MilestoneService milestoneService;

    @GetMapping("/milestone?milestone={milestoneId}")
    public ResponseEntity<MilestoneDto> getMileStone(@RequestParam Long milestoneId) {
        MilestoneDto milestoneDto = milestoneService.findById(milestoneId);
        return ResponseEntity.ok(milestoneDto);
    }

    @GetMapping("/milestone/list?project={projectId}")
    public ResponseEntity<List<MilestoneDto>> getMileStoneList(@RequestParam Long projectId) {
        List<MilestoneDto> milestoneDtos = milestoneService.findByProjectId(projectId);
        return ResponseEntity.ok(milestoneDtos);
    }

    @PostMapping("/milestone")
    public void createMileStone(@RequestBody MilestoneDto milestoneDto) {
        milestoneService.createMileStone(milestoneDto);
    }

    @PutMapping("/milestone?milestone={milestoneId}")
    public void updateMileStone(@RequestParam Long milestoneId, @RequestBody MilestoneDto milestoneDto) {
        milestoneService.updateMileStone(milestoneId, milestoneDto);
    }

    @DeleteMapping("/milestone?milestone={milestoneId}")
    public void deleteMileStone(@RequestParam Long milestoneId) {
        milestoneService.deleteMileStone(milestoneId);
    }


}
