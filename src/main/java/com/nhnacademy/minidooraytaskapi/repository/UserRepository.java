package com.nhnacademy.minidooraytaskapi.repository;

import com.nhnacademy.minidooraytaskapi.dto.UserGetDto;
import com.nhnacademy.minidooraytaskapi.dto.UserRegisterDto;
import com.nhnacademy.minidooraytaskapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    void deleteByUserUUID(String uuid);

    //TODO: updateByUserUUID 오류로 인해 주석처리
    //void updateByUserUUID(String uuid, UserRegisterDto userRegisterDto);

    User findByUserUUID(String uuid);

    User findByUserId(String userId);
}
