package com.bilitech.yilimusic.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class UserServiceTest extends BaseTest {

    @Autowired
    UserService userService;

    @Test
    void getCurrentUser() {
    }
}