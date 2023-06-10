package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.UserGetDto;
import com.nhnacademy.minidooraytaskapi.dto.UserRegisterDto;
import com.nhnacademy.minidooraytaskapi.entity.User;
import com.nhnacademy.minidooraytaskapi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/taskapi/users/{id}")
    public UserGetDto getUserByUUId(@PathVariable String UUID) {
        return userService.getUserByUUId(UUID);
    }


    @PostMapping("/taskapi/signup")
    public User create(@RequestBody UserRegisterDto userRegisterDto) {
        return userService.registerUser(userRegisterDto);
    }

    @DeleteMapping("/api/users/{id}")
    public void deleteByUUId(@PathVariable String UUID) {
        userService.deleteByUUId(UUID);
    }

    @PutMapping("/api/users/{id}")
    public void updateByUUId(@PathVariable String UUID, @RequestBody UserRegisterDto userRegisterDto) {
        userService.updateByUUId(UUID, userRegisterDto);
    }

}
