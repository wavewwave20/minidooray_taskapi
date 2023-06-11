package com.nhnacademy.minidooraytaskapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taskapi/projects")
public class ProjectController {

    @PostMapping("/create")
    public void createProject( ) {

    }
}
