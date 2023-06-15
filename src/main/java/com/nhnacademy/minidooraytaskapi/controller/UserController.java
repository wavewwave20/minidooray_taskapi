package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.dto.UserGetDto;
import com.nhnacademy.minidooraytaskapi.dto.UserRegisterDto;
import com.nhnacademy.minidooraytaskapi.entity.User;
import com.nhnacademy.minidooraytaskapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/list")
    public ResponseEntity<List<UserGetDto>> getAllUsers() {
        List<UserGetDto> userGetDtoList = userService.getAllUser();
        return ResponseEntity.ok(userGetDtoList);
    }


    @GetMapping("/user?user={userUUID}")
    public UserGetDto getUserByUUId(@RequestParam String userUUID) {
        return userService.getUserByUUId(userUUID);
    }

    @PostMapping("/user")
    public User create(@RequestBody UserRegisterDto userRegisterDto) {
        return userService.registerUser(userRegisterDto);
    }

    @DeleteMapping("/user?user={userUUID}")
    public void deleteByUUId(@RequestParam String userUUID) {
        userService.deleteByUUId(userUUID);
    }

    @PutMapping("/api/users/{id}")
    public void updateByUUId(@PathVariable String userUUID, @RequestBody UserRegisterDto userRegisterDto) {
        userService.updateByUUId(userUUID, userRegisterDto);
    }

}
