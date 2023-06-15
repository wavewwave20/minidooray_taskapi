package com.nhnacademy.minidooraytaskapi.repository;

import com.nhnacademy.minidooraytaskapi.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findTagsByProjectProjectId(Long projectId);

    void deleteTagsByProjectProjectId(Long projectId);
}
