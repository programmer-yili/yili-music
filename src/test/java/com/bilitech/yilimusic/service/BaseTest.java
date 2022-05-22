package com.bilitech.yilimusic.service;

import com.bilitech.yilimusic.core.dto.UserCreateRequest;
import com.bilitech.yilimusic.core.dto.UserDto;
import com.bilitech.yilimusic.core.entity.User;
import com.bilitech.yilimusic.core.enums.Gender;
import com.bilitech.yilimusic.core.repository.UserRepository;
import com.bilitech.yilimusic.core.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class BaseTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setDefaultUser() {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setUsername("yili");
        userCreateRequest.setNickname("yili");
        userCreateRequest.setPassword("900602");
        userCreateRequest.setGender(Gender.MALE);
        UserDto userDto = userService.create(userCreateRequest);

        User user = userService.loadUserByUsername(userDto.getUsername());
        userRepository.save(user);
    }
}
