package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.TagCreateDto;
import com.nhnacademy.minidooraytaskapi.dto.TagDto;
import com.nhnacademy.minidooraytaskapi.dto.UserGetDto;
import com.nhnacademy.minidooraytaskapi.entity.Tag;
import com.nhnacademy.minidooraytaskapi.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TagController {

    private final TagService tagService;

    @GetMapping("/tag?tag={tagId}")
    public TagDto getTagById(@RequestParam Long tagId) {
        return tagService.getTagById(tagId);
    }

    @GetMapping("/tag/list?project={projectId}")
    public ResponseEntity<List<TagDto>> getTagsByProjectId(@RequestParam Long projectId) {
        List<TagDto> tagDtos = tagService.getTagsByProjectId(projectId);
        return ResponseEntity.ok(tagDtos);
    }

    @PostMapping("/tag")
    public void createTag(@RequestBody TagCreateDto tagCreateDto) {
        tagService.createTag(tagCreateDto);
    }

    @PutMapping("/tag?tag={tagId}")
    public void updateTagById(@RequestParam Long tagId, @RequestBody TagDto tagDto) {
        tagService.updateTagById(tagId, tagDto);
    }

    @DeleteMapping("/tag?tag={tagId}")
    public void deleteTagById(@PathVariable Long tagId) {
        tagService.deleteTagById(tagId);
    }

}
