package com.bilitech.yilimusic.core.service;

import com.bilitech.yilimusic.core.dto.*;
import com.bilitech.yilimusic.core.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    UserDto create(UserCreateRequest userCreateRequest);

    @Override
    User loadUserByUsername(String username);

    UserDto get(String id);

    UserDto update(String id, UserUpdateRequest userUpdateRequest);

    void delete(String id);

    Page<UserDto> search(UserSearchFilter searchFilter);

    String createToken(TokenCreateRequest tokenCreateRequest);

    UserDto getCurrentUser();
}
