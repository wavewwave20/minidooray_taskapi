package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.MilestoneDto;
import com.nhnacademy.minidooraytaskapi.dto.TaskDto;
import com.nhnacademy.minidooraytaskapi.service.MilestoneTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/task")
public class MilstoneTaskController {

    private final MilestoneTaskService milestoneTaskService;

    public MilstoneTaskController(MilestoneTaskService milestoneTaskService) {
        this.milestoneTaskService = milestoneTaskService;
    }

    @PostMapping("/milestones/{milestoneId}/tasks/{taskId}")
    public ResponseEntity<?> createMilestoneTask(@PathVariable Long milestoneId, @PathVariable Long taskId) {
        milestoneTaskService.createMilestoneTask(milestoneId, taskId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/tasks/{taskId}/milestones")
    public ResponseEntity<List<MilestoneDto>> getMilestonesByTask(@PathVariable Long taskId) {
        List<MilestoneDto> milestoneDtos = milestoneTaskService.getMilestonesByTask(taskId);
        return ResponseEntity.ok(milestoneDtos);

    }

    @GetMapping("/milestones/{milestoneId}/tasks")
    public ResponseEntity<List<TaskDto>> getTasksByMilestone(@PathVariable Long milestoneId) {
        List<TaskDto> taskDtos = milestoneTaskService.getTasksByMilestone(milestoneId);
        return ResponseEntity.ok(taskDtos);
    }

    @DeleteMapping("/milestones/{milestoneId}/tasks/{taskId}")
    public ResponseEntity<?> deleteMilestoneTask(@PathVariable Long milestoneId, @PathVariable Long taskId) {
        milestoneTaskService.deleteMilestoneTask(milestoneId, taskId);
        return ResponseEntity.ok().build();
    }
}
