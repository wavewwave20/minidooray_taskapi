package com.nhnacademy.minidooraytaskapi.controller;

import com.nhnacademy.minidooraytaskapi.entity.User;
import com.nhnacademy.minidooraytaskapi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public User create() {
        User user = new User();
        //#TODO:user UUID GateWay에서 받아온걸로 대체-UUID 포함한 Dto로 변경해야 함
        user.setUserUUID(UUID.randomUUID().toString());
        user.setUserId("test");
        user.setUserNickname("test");

        userService.create(user);
        return user;
    }
}
