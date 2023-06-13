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
    //#TODO: Create Tag는 했는데.. Dto생각좀 해봐야할듯요?
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

    //#TODO: Task Tag Cascade처럼 삭제되는것 확인요망. Task쪽에서 해결해야 할 것 같아요

}
