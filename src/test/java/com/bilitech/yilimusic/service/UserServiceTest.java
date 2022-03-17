package com.bilitech.yilimusic.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
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

    @Test
    void createTokenByMp() {
        String token = userService.createTokenByOpenId("yili-openid");
        Assertions.assertNotNull(token);
        log.info(token);
    }
}