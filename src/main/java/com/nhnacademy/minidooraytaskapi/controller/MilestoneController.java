package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.MilestoneDto;
import com.nhnacademy.minidooraytaskapi.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MilestoneController {

    private final MilestoneService milestoneService;

    @GetMapping("/milestone?milestone={milestoneId}")
    public MilestoneDto getMileStone(@RequestParam Long milestoneId) {
        return milestoneService.findById(milestoneId);
    }

    @PostMapping("/milestone/")
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
