package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.TagDto;
import com.nhnacademy.minidooraytaskapi.dto.UserGetDto;
import com.nhnacademy.minidooraytaskapi.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/taskapi/tags")
public class TagController {

    private final TagService tagService;

    @GetMapping("/")
    public List<TagDto> getAllTag() {
        return tagService.getAllTag();
    }

    @GetMapping("/{tagId}")
    public TagDto getTagById(@PathVariable Long tagId) {
        return tagService.getTagById(tagId);
    }

    @PostMapping("/")
    public void createTag(@RequestBody TagDto tagDto) {
        tagService.createTag(tagDto);
    }

    @PutMapping("/{tagId}")
    public void updateTagById(@PathVariable Long tagId, @RequestBody TagDto tagDto) {
        tagService.updateTagById(tagId, tagDto);
    }

    @DeleteMapping("/{tagId}")
    public void deleteTagById(@PathVariable Long tagId) {
        tagService.deleteTagById(tagId);
    }

    @GetMapping("/search/{tagId}")
    public UserGetDto getUserByTagId(@PathVariable Long tagId) {
        return tagService.getUserByTagId(tagId);
    }

}
