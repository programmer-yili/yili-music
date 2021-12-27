package com.bilitech.yilimusic.service;

import com.bilitech.yilimusic.dto.UserCreateDto;
import com.bilitech.yilimusic.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    List<UserDto> list();

    UserDto create(UserCreateDto userCreateDto);
}
