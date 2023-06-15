package com.nhnacademy.minidooraytaskapi.service;

import com.nhnacademy.minidooraytaskapi.dto.TagCreateDto;
import com.nhnacademy.minidooraytaskapi.dto.TagDto;
import com.nhnacademy.minidooraytaskapi.dto.UserGetDto;
import com.nhnacademy.minidooraytaskapi.entity.Tag;
import com.nhnacademy.minidooraytaskapi.entity.User;
import com.nhnacademy.minidooraytaskapi.repository.ProjectRepository;
import com.nhnacademy.minidooraytaskapi.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    private final TaskTagService taskTagService;

    private final ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public List<TagDto> getAllTag() {
        List<Tag> tagList = tagRepository.findAll();
        List<TagDto> tagDtoList = new java.util.ArrayList<>();
        for (Tag tag : tagList) {
            tagDtoList.add(toDto(tag));
        }
        return tagDtoList;
    }

    @Transactional(readOnly = true)
    public TagDto getTagById(Long tagId) {
        Tag tag = tagRepository.findById(tagId).orElseThrow();
        return toDto(tag);
    }

    @Transactional(readOnly = true)
    public List<TagDto> getTagsByProjectId(Long projectId) {
        List<Tag> tagList = tagRepository.findTagsByProjectProjectId(projectId);
        List<TagDto> tagDtoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagDtoList.add(toDto(tag));
        }
        return tagDtoList;
    }


    @Transactional
    public void createTag(TagCreateDto tagDto) {
        tagRepository.save(toEntity(tagDto));
    }

    @Transactional
    public void updateTagById(Long tagId, TagDto tagDto) {
        Tag tag = tagRepository.findById(tagId).orElseThrow();
        tag.setTagName(tagDto.getTagName());
        tagRepository.save(tag);
    }

    @Transactional
    public void deleteTagById(Long tagId) {
        taskTagService.deleteTaskTagByTagId(tagId);
        tagRepository.deleteById(tagId);
    }



    public Tag toEntity(TagCreateDto tagDto) {
        Tag tag = new Tag();
        tag.setTagName(tagDto.getTagName());
        tag.setProject(projectRepository.findById(tagDto.getProjectId()).orElseThrow());
        return tag;
    }

    public TagDto toDto(Tag tag) {
        TagDto tagDto = new TagDto();
        tagDto.setTagId(tag.getTagId());
        tagDto.setTagName(tag.getTagName());
        tagDto.setProjectId(tag.getProject().getProjectId());
        return tagDto;
    }

    public UserGetDto toUserDto(User user) {
        UserGetDto userDto = new UserGetDto();
        userDto.setUserUUID(user.getUserUUID());
        userDto.setUserId(user.getUserId());
        userDto.setUserNickName(user.getUserNickname());
        userDto.setUserEmail(user.getUserEmail());
        return userDto;
    }

    @Transactional(readOnly = true)
    public UserGetDto getUserByTagId(Long tagId) {
        User user = tagRepository.findById(tagId).orElseThrow().getProject().getUser();
        return toUserDto(user);
    }


}
