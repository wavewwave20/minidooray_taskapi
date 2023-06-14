package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.MilestoneDto;
import com.nhnacademy.minidooraytaskapi.dto.TaskDto;
import com.nhnacademy.minidooraytaskapi.service.MilestoneTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class MilstoneTaskController {

    private final MilestoneTaskService milestoneTaskService;

    public MilstoneTaskController(MilestoneTaskService milestoneTaskService) {
        this.milestoneTaskService = milestoneTaskService;
    }

    @PostMapping("/milestone-task?milestone={milestoneId}&task={taskId}")
    public void createMilestoneTask(@RequestParam Long milestoneId, @RequestParam Long taskId) {
        milestoneTaskService.createMilestoneTask(milestoneId, taskId);
    }

    @GetMapping("/milestone-task/list?task={taskId}")
    public ResponseEntity<List<MilestoneDto>> getMilestonesByTask(@RequestParam Long taskId) {
        List<MilestoneDto> milestoneDtos = milestoneTaskService.getMilestonesByTask(taskId);
        return ResponseEntity.ok(milestoneDtos);

    }

    @GetMapping("/milestone-task/list?milestone={milestoneId}")
    public ResponseEntity<List<TaskDto>> getTasksByMilestone(@RequestParam Long milestoneId) {
        List<TaskDto> taskDtos = milestoneTaskService.getTasksByMilestone(milestoneId);
        return ResponseEntity.ok(taskDtos);
    }

    @DeleteMapping("/milestone-task?milestone={milestoneId}&task={taskId}")
    public void deleteMilestoneTask(@RequestParam Long milestoneId, @RequestParam Long taskId) {
        milestoneTaskService.deleteMilestoneTask(milestoneId, taskId);
    }
}
