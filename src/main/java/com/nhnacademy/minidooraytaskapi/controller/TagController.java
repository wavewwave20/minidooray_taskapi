package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.TagCreateDto;
import com.nhnacademy.minidooraytaskapi.dto.TagDto;
import com.nhnacademy.minidooraytaskapi.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class TagController {

    private final TagService tagService;

    @GetMapping("/tags/{tagId}")
    public TagDto getTagById(@PathVariable Long tagId) {
        return tagService.getTagById(tagId);
    }

    @GetMapping("/tags/projects/{projectId}")
    public ResponseEntity<List<TagDto>> getTagsByProjectId(@PathVariable Long projectId) {
        List<TagDto> tagDtos = tagService.getTagsByProjectId(projectId);
        return ResponseEntity.ok(tagDtos);
    }

    @PostMapping("/tags")
    public void createTag(@RequestBody TagCreateDto tagCreateDto) {
        tagService.createTag(tagCreateDto);
    }

    @PutMapping("/tags/{tagId}")
    public void updateTagById(@PathVariable Long tagId, @RequestBody TagDto tagDto) {
        tagService.updateTagById(tagId, tagDto);
    }

    @DeleteMapping("/tags/{tagId}")
    public void deleteTagById(@PathVariable Long tagId) {
        tagService.deleteTagById(tagId);
    }

}
