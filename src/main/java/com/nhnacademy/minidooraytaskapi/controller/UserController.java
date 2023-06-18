package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.UserGetDto;
import com.nhnacademy.minidooraytaskapi.dto.UserRegisterDto;
import com.nhnacademy.minidooraytaskapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/task")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserGetDto>> getAllUsers() {
        List<UserGetDto> userGetDtoList = userService.getAllUser();
        return ResponseEntity.ok(userGetDtoList);
    }

    @GetMapping("/users/{userUUID}")
    public UserGetDto getUserByUUId(@PathVariable String userUUID) {
        return userService.getUserByUUId(userUUID);
    }

    @PostMapping("/users")
    public UserGetDto create(@RequestBody UserRegisterDto userRegisterDto) {
        return userService.registerUser(userRegisterDto);
    }

    @DeleteMapping("/users/{userUUID}")
    public void deleteByUUId(@PathVariable String userUUID) {
        userService.deleteByUUId(userUUID);
    }

    @PutMapping("/users/{userUUID}")
    public void updateByUUId(@PathVariable String userUUID, @RequestBody UserRegisterDto userRegisterDto) {
        userService.updateByUUId(userUUID, userRegisterDto);
    }

}
