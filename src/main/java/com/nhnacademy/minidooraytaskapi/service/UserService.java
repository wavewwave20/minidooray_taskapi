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

    @Transactional
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public UserGetDto registerUser(UserRegisterDto userRegisterDto) {
        User user = new User();
        user.setUserUUID(userRegisterDto.getUserUUID());
        user.setUserId(userRegisterDto.getUserId());
        user.setUserNickname(userRegisterDto.getUserNickName());
        user.setUserEmail(userRegisterDto.getUserEmail());
        userRepository.save(user);

        UserGetDto userGetDto = new UserGetDto();
        userGetDto.setUserUUID(user.getUserUUID());
        userGetDto.setUserId(user.getUserId());
        userGetDto.setUserNickName(user.getUserNickname());
        userGetDto.setUserEmail(user.getUserEmail());
        return userGetDto;
    }

    @Transactional
    public void deleteByUUId(String uuid) {
        userRepository.deleteByUserUUID(uuid);
    }


    @Transactional
    public void updateByUUId(String uuid, UserRegisterDto userRegisterDto) {
        UserGetDto userDto = getUserByUUId(uuid);
        userDto.setUserNickName(userRegisterDto.getUserNickName());
        userDto.setUserEmail(userRegisterDto.getUserEmail());

        User user = new User();
        user.setUserUUID(userDto.getUserUUID());
        user.setUserId(userDto.getUserId());
        user.setUserNickname(userDto.getUserNickName());
        user.setUserEmail(userDto.getUserEmail());
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    public UserGetDto getUserByUserId(String userId) {
        return toUserGetDto(userRepository.findByUserId(userId));
    }

    @Transactional(readOnly = true)
    public List<UserGetDto> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserGetDto> userGetDtoList = new ArrayList<>();

        for(User user : users) {
            userGetDtoList.add(toUserGetDto(user));
        }
        return userGetDtoList;
    }

    @Transactional(readOnly = true)
    public UserGetDto toDto(User user) {
        UserGetDto userGetDto = new UserGetDto();
        userGetDto.setUserUUID(user.getUserUUID());
        userGetDto.setUserId(user.getUserId());
        userGetDto.setUserNickName(user.getUserNickname());
        userGetDto.setUserEmail(user.getUserEmail());
        return userGetDto;
    }

}
