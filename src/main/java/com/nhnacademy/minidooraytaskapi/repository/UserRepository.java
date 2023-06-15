package com.nhnacademy.minidooraytaskapi.repository;

import com.nhnacademy.minidooraytaskapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    void deleteByUserUUID(String uuid);

    User findByUserUUID(String uuid);

    User findByUserId(String userId);


}
