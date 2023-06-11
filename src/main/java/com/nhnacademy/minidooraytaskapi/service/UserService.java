package com.nhnacademy.minidooraytaskapi.service;

import com.nhnacademy.minidooraytaskapi.dto.UserGetDto;
import com.nhnacademy.minidooraytaskapi.dto.UserRegisterDto;
import com.nhnacademy.minidooraytaskapi.entity.User;
import com.nhnacademy.minidooraytaskapi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User registerUser(UserRegisterDto userRegisterDto) {
        User user = new User();
        user.setUserUUID(userRegisterDto.getUserUUID());
        user.setUserId(userRegisterDto.getUserId());
        user.setUserNickname(userRegisterDto.getUserNickName());
        user.setUserEmail(userRegisterDto.getUserEmail());
        return userRepository.save(user);
    }

    public void deleteByUUId(String uuid) {
        userRepository.deleteByUserUUID(uuid);
    }

//    public void updateByUUId(String uuid, UserRegisterDto userRegisterDto) {
//        userRepository.updateByUserUUID(uuid, userRegisterDto);
//    }

    public UserGetDto getUserByUUId(String uuid) {
        return toUserGetDto(userRepository.findByUserUUID(uuid));
    }

    public UserGetDto toUserGetDto(User user) {
        UserGetDto userGetDto = new UserGetDto();
        userGetDto.setUserUUID(user.getUserUUID());
        userGetDto.setUserId(user.getUserId());
        userGetDto.setUserNickName(user.getUserNickname());
        userGetDto.setUserEmail(user.getUserEmail());
        return userGetDto;
    }

    public UserGetDto getUserByUserId(String userId) {
        return toUserGetDto(userRepository.findByUserId(userId));
    }

    public List<UserGetDto> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserGetDto> userGetDtoList = new ArrayList<>();

        for(User user : users) {
            userGetDtoList.add(toUserGetDto(user));
        }
        return userGetDtoList;
    }

}
