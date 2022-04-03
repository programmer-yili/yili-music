package com.bilitech.yilimusic.controller;

import com.bilitech.yilimusic.dto.PaymentDto;
import com.bilitech.yilimusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tokens")
public class TokenController {


    UserService userService;

    @PostMapping
    public String create(@RequestBody PaymentDto paymentDto) {
        return paymentDto.toString();
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
